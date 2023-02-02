package com.msb.dao.impl;

import com.msb.dao.CourseDao;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 11:09
 */
public class CourseDaoImpl implements CourseDao {

    private String subject;

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void add() {
        System.out.println("CourseDaoImpl执行......,课题为:" + subject);
    }
}
