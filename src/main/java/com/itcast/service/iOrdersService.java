package com.itcast.service;

import com.itcast.domain.Orders;

import java.util.List;

public interface iOrdersService {

    //查询所有订单
    List<Orders> findAll(int page,int size);

    Orders findById(int id);
}
