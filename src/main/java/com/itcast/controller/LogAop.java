package com.itcast.controller;

import com.itcast.domain.SysLog;
import com.itcast.service.iSysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    private Date visitTIme; //开始时间
    private Class classes; //访问的类
    private Method method; //访问的方法

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private iSysLogService sysLogService;

    /**
     * 前置通知 获取开始时间，执行的类是哪一个，执行的是哪一个方法
     */
    @Before("execution(* com.itcast.controller.*.*(..))")
    public void doBefore(JoinPoint jp) throws NoSuchMethodException {

        //当前时间就是开始访问的时间
        visitTIme=new Date();

        //具体要访问的类
        classes=jp.getTarget().getClass();

        //获取当前访问方法的名字
        String methodName=jp.getSignature().getName();
        //获取访问方法的参数
        Object[] args = jp.getArgs();

        //获取具体执行方法得Method方法对象
        if(args==null || args.length==0){

            //只能获取无参数的方法
            method=classes.getMethod(methodName);
        }else {
            Class[] classArgs=new Class[args.length];

            for (int i=0;i<args.length;i++){
                classArgs[i]=args[i].getClass();
            }
            classes.getMethod(methodName,classArgs);
        }

    }

    /**
     * 后置通知
     */
    @After("execution(* com.itcast.controller.*.*(..))")
    public void doAfter(){
        //获取访问的时长
        long time=new Date().getTime()-visitTIme.getTime();

        String url="";
        //获取url
        if(classes!=null && method!=null && classes!= LogAop.class){

            //1,获取类上@RequestMapping(xxx)
            RequestMapping classesAnnotation = (RequestMapping) classes.getAnnotation(RequestMapping.class);

            if(classesAnnotation!=null){
                String[] classValue = classesAnnotation.value();

                //2.获取方法上的@RequestMapping(xxx);
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);

                if(methodAnnotation != null){
                    String[] methonValue = methodAnnotation.value();

                    url=classValue[0]+methonValue[0];

                    //获取访问的IP地址
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户
                    //从上下文中获取当前登录的用户
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志相关信息封装到SyLog对象

                    SysLog sysLog=new SysLog();
                    sysLog.setExecutionTime(time); //执行时长
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名]"+classes.getName()+"[方法名]"+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTIme);

                    sysLogService.save(sysLog);
                }
            }
        }


    }
}
