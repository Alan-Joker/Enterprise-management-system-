package com.itcast.dao;

import com.itcast.domain.Permission;

import java.util.List;

public interface iPermissionDao {

    /**
     * 查询所有资源权限
     */

    List<Permission> findAll();
}
