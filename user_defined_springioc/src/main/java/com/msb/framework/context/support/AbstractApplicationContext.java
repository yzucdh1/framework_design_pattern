package com.msb.framework.context.support;

import com.msb.framework.beans.factory.support.BeanDefinitionReader;
import com.msb.framework.beans.factory.support.BeanDefinitionRegistry;
import com.msb.framework.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 9:51
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    protected BeanDefinitionReader beanDefinitionReader;

    protected String configLocation;

    protected Map<String, Object> singletons = new HashMap<>();

    @Override
    public void refresh() {
        try {
            // 加载配置文件
            beanDefinitionReader.loadBeanDefinitions(configLocation);

            // 初始化
            finishInitialization();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 初始化
    protected void finishInitialization() throws Exception {
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            getBean(beanDefinitionName);
        }
    }
}
