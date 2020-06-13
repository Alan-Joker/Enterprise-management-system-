package com.itcast.dao;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;

import java.util.List;

public interface iRoleDao {

    /**
     * 通过id查询角色详细信息
     * @param id
     * @return
     */
    Role findById(int id);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 保存角色信息
     * @param roleName
     * @param roleDesc
     */
    void save(String roleName, String roleDesc);
}
