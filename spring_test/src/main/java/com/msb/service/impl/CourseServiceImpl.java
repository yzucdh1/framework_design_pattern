package com.msb.service.impl;

import com.msb.dao.CourseDao;
import com.msb.service.CourseService;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 11:10
 */
public class CourseServiceImpl implements CourseService {

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void add() {
        System.out.println("CourseServiceImpl执行......");
        courseDao.add();
    }
}
