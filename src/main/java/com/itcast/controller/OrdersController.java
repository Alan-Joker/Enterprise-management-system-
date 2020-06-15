package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Orders;
import com.itcast.service.iOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private iOrdersService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(Integer page,Integer size){

        ModelAndView mv=new ModelAndView();
        List<Orders> orders = service.findAll(page,size);

        //PageInfok就是一个分页Bean
        PageInfo pageInfo=new PageInfo(orders);

        mv.addObject("ordersList",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/findById")
    public ModelAndView findById(int id){
        ModelAndView mv=new ModelAndView();
        Orders orders=service.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
}
