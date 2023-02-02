package com.msb.framework.context;

import com.msb.framework.beans.factory.BeanFactory;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 9:46
 */
public interface ApplicationContext extends BeanFactory {

    // 进行配置文件加载,并进行对象的创建
    void refresh();
}
