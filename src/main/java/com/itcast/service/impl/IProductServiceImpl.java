package com.itcast.service.impl;

import com.itcast.domain.Product;
import com.itcast.service.iProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itcast.dao.iProductDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IProductServiceImpl implements iProductService {

    @Autowired
    private iProductDao dao;

    @Override
    public List<Product> findAll() {

        return dao.findAll();
    }

    @Override
    public void save(Product product) {

        dao.save(product);
    }
}
