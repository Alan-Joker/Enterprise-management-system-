package com.itcast.controller;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.SysLog;
import com.itcast.service.iSysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private iSysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(Integer page,Integer size) throws Exception {
        ModelAndView mv = new ModelAndView();

        List<SysLog> sysLogs = sysLogService.findAll(page, size);

        PageInfo pageInfo = new PageInfo(sysLogs);

        mv.addObject("sysLogs", pageInfo);

        mv.setViewName("syslog-list");
        return mv;
    }
}
