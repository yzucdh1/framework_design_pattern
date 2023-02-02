package com.msb.mapper;

import com.msb.domain.User;

import java.util.List;

/**
 * @author chendonghui
 * @version 1.0.0
 * @create 2023/2/2 13:16
 */
public interface UserMapper {

    List<User> findAll();
}
