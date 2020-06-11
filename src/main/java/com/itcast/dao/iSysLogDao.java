package com.itcast.dao;

import com.itcast.domain.SysLog;

import java.util.List;

public interface iSysLogDao {

    void save(SysLog sysLog);

    List<SysLog> findAll();

}
