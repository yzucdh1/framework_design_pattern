package com.msb.framework.beans.factory;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 9:42
 */
public interface BeanFactory {

    Object getBean(String name) throws Exception;

    // 泛型方法,传入当前类或者其子类
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
