package com.msb.framework.beans;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 8:33
 */
public class PropertyValue {

    private String name;

    private String ref;

    private String value;

    public PropertyValue() {
    }

    public PropertyValue(String name, String ref, String value) {
        this.name = name;
        this.ref = ref;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PropertyValue{" +
                "name='" + name + '\'' +
                ", ref='" + ref + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
