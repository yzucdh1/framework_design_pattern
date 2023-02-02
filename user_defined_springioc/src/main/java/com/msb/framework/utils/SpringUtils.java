package com.msb.framework.utils;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 10:36
 */
public final class SpringUtils {

    private SpringUtils() {
    }

    public static String getSetMethodName(String name) {
        return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
