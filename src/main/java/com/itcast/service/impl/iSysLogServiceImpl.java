package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.iSysLogDao;
import com.itcast.domain.SysLog;
import com.itcast.service.iSysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class iSysLogServiceImpl implements iSysLogService {

    @Autowired
    private iSysLogDao dao;
    @Override
    public void save(SysLog sysLog) {
        dao.save(sysLog);
    }

    @Override
    public List<SysLog> findAll(int page,int size) throws Exception {

        PageHelper.startPage(page,size);
        return dao.findAll();
    }
}
