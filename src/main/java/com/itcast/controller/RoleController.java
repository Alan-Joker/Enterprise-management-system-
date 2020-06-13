package com.itcast.controller;

import com.itcast.domain.Role;
import com.itcast.service.iRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private iRoleService service;


    /**
     * 查询所有角色信息
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv=new ModelAndView();

        List<Role> all = service.findAll();

        mv.addObject("roleList",all);
        mv.setViewName("role-list");
        return mv;
    }

    /**
     * 跳转到role-add.jsp
     */
    @RequestMapping("/role-add")
    public String toRoleAdd(){
        return "role-add";
    }

    /**
     * 保存角色信息
     */

    @RequestMapping("/save")
    public String save(String roleName,String roleDesc){

        service.save(roleName,roleDesc);

        return "redirect:findAll";
    }
}
