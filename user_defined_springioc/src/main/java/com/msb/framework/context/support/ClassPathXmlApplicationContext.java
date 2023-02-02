package com.msb.framework.context.support;

import com.msb.framework.beans.BeanDefinition;
import com.msb.framework.beans.MutablePropertyValues;
import com.msb.framework.beans.PropertyValue;
import com.msb.framework.beans.factory.support.BeanDefinitionRegistry;
import com.msb.framework.beans.factory.xml.XMLBeanDefinitionReader;
import com.msb.framework.utils.SpringUtils;

import java.lang.reflect.Method;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 9:57
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beanDefinitionReader = new XMLBeanDefinitionReader();
        this.configLocation = configLocation;
        // 上下文创建好后,对象就创建好了,非延时创建
        this.refresh();
    }

    @Override
    public Object getBean(String name) throws Exception {
        Object obj = singletons.get(name);
        if (obj != null) {
            return obj;
        }

        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);

        // 利用发射创建对象
        String className = beanDefinition.getClassName();
        Class<?> clazz = Class.forName(className);
        Object beanObj = clazz.newInstance();

        // 设置属性
        MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();

        for (PropertyValue propertyValue : propertyValues) {
            String pName = propertyValue.getName();
            String pRef = propertyValue.getRef();
            String pValue = propertyValue.getValue();

            String methodName = SpringUtils.getSetMethodName(pName);

            if (pRef != null && !"".equals(pRef)) {
                Object bean = getBean(pRef);
                Method[] methods = clazz.getMethods();

                for (Method method : methods) {
                    if (methodName.equals(method.getName())) {
                        method.invoke(beanObj, bean);
                    }
                }
            } else if (pValue != null && !"".equals(pValue)) {
                Method method = clazz.getMethod(methodName, String.class);
                method.invoke(beanObj, pValue);
            }
        }

        singletons.put(name, beanObj);
        return beanObj;
    }

    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (bean == null) {
            return null;
        }
        return clazz.cast(bean);
    }
}
