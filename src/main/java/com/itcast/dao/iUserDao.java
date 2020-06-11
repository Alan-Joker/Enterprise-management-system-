package com.itcast.dao;

import com.itcast.domain.UserInfo;

import java.util.List;

public interface iUserDao {

    //通过用户名查找用户
    UserInfo findByUsername(String username);

    //查找所有用户
    List<UserInfo> findAll();

    //保存用户信息
    void save(UserInfo userInfo);

    //根据id查询用户详细信息
    UserInfo findAllById(int id);
}