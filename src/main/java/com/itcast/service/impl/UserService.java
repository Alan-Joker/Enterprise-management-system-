package com.itcast.service.impl;

import com.itcast.dao.iRoleDao;
import com.itcast.dao.iUserDao;
import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.service.iUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserService implements iUserService {

    @Autowired
    private iUserDao dao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo=null;
        try {
             userInfo = dao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //处理自己的用户对象封装成UserDetails
        //User user=new User(userInfo.getUsername(),userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user=new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus()==0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));

        return user;
    }

    //作用就是返回一个List集合，及合作装入的是角色的描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){

        List<SimpleGrantedAuthority> list=new ArrayList();

        for (Role role : roles) {

            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));

        }

        return list;
    }

    /**
     * 查询所有用户
     * @return
     */
    @Override
    public List<UserInfo> findAll() {

        return dao.findAll();
    }

    /**
     * 保存用户
     * @param userInfo
     */
    @Override
    public void save(UserInfo userInfo) {

        //对密码加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        dao.save(userInfo);
    }

    /**
     * 根据id查询用户详细信息
     * @param id
     * @return
     */
    @Override
    public UserInfo findAllById(int id) {

        return dao.findAllById(id);
    }

}
