package com.itcast.controller;

import com.itcast.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.itcast.service.iProductService;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController {
    Map<String ,Object> map=new HashMap<String,Object>();

    @Autowired
    private iProductService service;

    /**
     * 查询全部产品
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv=new ModelAndView();

        List<Product> all = service.findAll();

        mv.addObject("productList",all);
        mv.setViewName("product-list2");
        return mv;
    }

    @GetMapping("/goAdd")
    public String goAdd(){

        return "product-add";
    }
    /**
     * 添加产品
     * @param product
     */
    @RequestMapping("/save")
    public String save(Product product){

        service.save(product);
        //重新查询产品信息
        return "redirect:findAll";
    }

}
