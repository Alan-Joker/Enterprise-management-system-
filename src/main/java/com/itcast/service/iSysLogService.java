package com.itcast.service;

import com.itcast.domain.SysLog;

import java.util.List;

public interface iSysLogService {

    void save(SysLog sysLog);

    List<SysLog> findAll(int page,int size) throws Exception;

}
