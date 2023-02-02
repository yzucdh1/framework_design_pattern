package com.msb.controller;

import com.msb.framework.context.support.ClassPathXmlApplicationContext;
import com.msb.service.CourseService;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 11:13
 */
public class CourseController {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        CourseService service = context.getBean("courseService", CourseService.class);
        service.add();
    }
}
