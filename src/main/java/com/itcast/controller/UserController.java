package com.itcast.controller;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.iRoleService;
import com.itcast.service.iUserService;
import com.itcast.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private iUserService service;

    @Autowired
    private iRoleService roleService;

    /**
     * 查询所有用户
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll(){

        ModelAndView mv=new ModelAndView();

        List<UserInfo> userList = service.findAll();

        mv.addObject("userList",userList);

        mv.setViewName("user-list");
        return mv;
    }

    /**
     * 跳转到user-add.jsp页面
     */

    @RequestMapping("/user-add")
    public String toUserAdd(){

        return "user-add";
    }
    /**
     * 用户添加
     */
    @RequestMapping("/save")
    public String save(UserInfo userInfo){

        service.save(userInfo);
        return "redirect:findAll";
    }

    /**
     * 查询指定id的用户详细信息
     */

    @RequestMapping("/findById")
    public ModelAndView findById(int id){
        ModelAndView mv=new ModelAndView();

//        Role info = roleService.findById(id);
        UserInfo info = service.findAllById(id);
        mv.addObject("user",info);
        mv.setViewName("user-show");
        return mv;
    }
}
