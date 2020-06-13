package com.itcast.service;

import com.itcast.domain.Permission;

import java.util.List;

public interface iPermissionService {

    /**
     * 查询所有资源权限
     */

    List<Permission> findAll();
}
