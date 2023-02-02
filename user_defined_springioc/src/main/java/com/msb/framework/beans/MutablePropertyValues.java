package com.msb.framework.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 8:36
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {

    private List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new ArrayList<>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    // 获取迭代器对象
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }

    // 获取所有的propertyValues
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    // 根据name属性获取propertyValue
    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(name)) {
                return propertyValue;
            }
        }
        return null;
    }

    // 判断集合是否为空
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    // 添加propertyValue
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue) {
        for (int i = 0; i < propertyValueList.size(); i++) {
            if (propertyValueList.get(i).getName().equals(propertyValue.getName())) {
                propertyValueList.set(i, propertyValue);
                return this;
            }
        }
        propertyValueList.add(propertyValue);
        return this;
    }

    // 判断是否包含指定名字的propertyValue
    public boolean contains(String name) {
        return getPropertyValue(name) != null;
    }
}
