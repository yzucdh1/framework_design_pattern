package com.msb.framework.beans.factory.xml;

import com.msb.framework.beans.BeanDefinition;
import com.msb.framework.beans.MutablePropertyValues;
import com.msb.framework.beans.PropertyValue;
import com.msb.framework.beans.factory.support.BeanDefinitionReader;
import com.msb.framework.beans.factory.support.BeanDefinitionRegistry;
import com.msb.framework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 9:19
 */
public class XMLBeanDefinitionReader implements BeanDefinitionReader {

    private BeanDefinitionRegistry registry;

    public XMLBeanDefinitionReader() {
        this.registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    // 加载配置文件,将BeanDefinition注册到注册表
    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        // 利用dom4j解析xml文件
        SAXReader reader = new SAXReader();

        InputStream ins = XMLBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(ins);

        parseBeanDefinition(document);
    }

    private void parseBeanDefinition(Document document) {
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();

        for (Element element : elements) {
            String id = element.attributeValue("id");
            String className = element.attributeValue("class");

            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);

            // 获取property子标签
            List<Element> elementList = element.elements("property");

            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();

            for (Element property : elementList) {
                String pName = property.attributeValue("name");
                String pRef = property.attributeValue("ref");
                String pValue = property.attributeValue("value");

                PropertyValue propertyValue = new PropertyValue(pName, pRef, pValue);
                mutablePropertyValues.addPropertyValue(propertyValue);
            }

            beanDefinition.setPropertyValues(mutablePropertyValues);

            registry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
