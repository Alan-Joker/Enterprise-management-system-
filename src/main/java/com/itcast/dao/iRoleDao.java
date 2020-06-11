package com.itcast.dao;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;

public interface iRoleDao {

    /**
     * 通过id查询角色详细信息
     * @param id
     * @return
     */
    Role findById(int id);

}
