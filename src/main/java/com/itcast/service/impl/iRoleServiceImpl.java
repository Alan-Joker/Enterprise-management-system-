package com.itcast.service.impl;

import com.itcast.dao.iRoleDao;
import com.itcast.domain.Role;
import com.itcast.service.iRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class iRoleServiceImpl implements iRoleService {

    @Autowired
    private iRoleDao dao;

    @Override
    public Role findById(int id) {
        Role byId = dao.findById(id);
        return byId;
    }

    @Override
    public List<Role> findAll() {

        return dao.findAll();
    }

    @Override
    public void save(String roleName, String roleDesc) {
        dao.save(roleName,roleDesc);
    }
}
