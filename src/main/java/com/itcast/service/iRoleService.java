package com.itcast.service;

import com.itcast.domain.Role;

import java.util.List;

public interface iRoleService {

    /**
     * 通过id查询角色信息
     * @param id
     * @return
     */
    Role findById(int id);


    /**
     * 查询所有用户信息
     * @return
     */
    List<Role> findAll();

    /**
     * 保存用户信息
     */

    void save(String roleName,String roleDesc);
}
