package com.msb;

import com.msb.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 13:21
 */
public class Main {

    public static void main(String[] args) throws Exception {
        SqlSessionFactoryBuilder factoryBuilder = new SqlSessionFactoryBuilder();

        InputStream ins = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = factoryBuilder.build(ins);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("com.msb.mapper.UserMapper.findAll");

        for (User user : userList) {
            System.out.println(user);
        }

        // 释放资源
        sqlSession.close();
    }
}
