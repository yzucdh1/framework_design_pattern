package com.msb.framework.beans.factory.support;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 9:17
 */
public interface BeanDefinitionReader {

    // 获取注册表对象
    BeanDefinitionRegistry getRegistry();

    // 加载配置文件并在注册表中进行注册
    void loadBeanDefinitions(String configLocation) throws Exception;
}
