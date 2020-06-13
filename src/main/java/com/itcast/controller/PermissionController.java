package com.itcast.controller;

import com.itcast.domain.Permission;
import com.itcast.service.iPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private iPermissionService service;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv=new ModelAndView();

        List<Permission> all = service.findAll();

        mv.addObject("permission",all);
        mv.setViewName("permission");
        return mv;
    }
}
