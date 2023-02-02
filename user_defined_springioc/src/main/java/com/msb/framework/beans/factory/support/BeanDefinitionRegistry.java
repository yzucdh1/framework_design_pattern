package com.msb.framework.beans.factory.support;

import com.msb.framework.beans.BeanDefinition;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 9:10
 */
public interface BeanDefinitionRegistry {

    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    void removeBeanDefinition(String beanName);

    BeanDefinition getBeanDefinition(String beanName);

    boolean containsBeanDefinition(String beanName);

    String[] getBeanDefinitionNames();

    int getBeanDefinitionCount();
}
