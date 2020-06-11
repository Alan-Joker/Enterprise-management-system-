package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.iOrdersDao;
import com.itcast.domain.Orders;
import com.itcast.service.iOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class iOrdersServiceImpl implements iOrdersService {

    @Autowired
    private iOrdersDao dao;

    @Override
    public List<Orders> findAll(int page,int size) {

        //page是页码，size是每页显示的条数
        PageHelper.startPage(page, size);
        return dao.findAll();
    }

    @Override
    public Orders findById(int id) {

        return dao.findById(id);
    }
}
