package com.itcast.service;

import com.itcast.domain.Product;

import java.util.List;

public interface iProductService {

    //查询所有的产品信息
    List<Product> findAll();

    //保存产品信息
    void save(Product product);
}
