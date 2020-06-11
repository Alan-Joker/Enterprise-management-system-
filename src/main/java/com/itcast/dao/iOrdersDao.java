package com.itcast.dao;

import com.itcast.domain.Orders;

import java.util.List;

public interface iOrdersDao {

    //查询所有订单
    List<Orders> findAll();

    Orders findById(int id);
}
