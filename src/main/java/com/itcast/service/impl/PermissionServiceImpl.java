package com.itcast.service.impl;

import com.itcast.dao.iPermissionDao;
import com.itcast.domain.Permission;
import com.itcast.service.iPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements iPermissionService {

    @Autowired
    private iPermissionDao dao;

    @Override
    public List<Permission> findAll() {

        return dao.findAll();
    }
}
