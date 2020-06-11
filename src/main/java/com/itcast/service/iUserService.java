package com.itcast.service;

import com.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface iUserService extends UserDetailsService {

    /**
     * 查询所有
     * @return
     */
    List<UserInfo> findAll();

    /**
     * 保存用户信息
     * @param userInfo
     */
    void save(UserInfo userInfo);


    /**
     * 根据id查询用户详细信息
     */

    UserInfo findAllById(int id);
}
