package com.hzit.aop;

import com.hzit.bean.AdminLog;
import com.hzit.bean.Employee;
import com.hzit.mapper.AdminLogMapper;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Component
@Aspect
public class MyAspect {
    @Autowired
    private AdminLogMapper adminLogMapper;
    private Logger logger = Logger.getLogger(MyAspect.class);

    /**
     * 定义切入点
     */
    @Pointcut("execution(* com.hzit.service.*.goMain123(..))")
    public void findMethod() {

    }

    /**
     * 前置增强
     */
    @Before("findMethod()")
    public void beforeAdvice() {

        System.out.println("Before前置增强处理");
    }

    /**
     * 前置增强
     */
    @After("findMethod()")
    public void finallyAfterAdvice() {
        System.out.println("After最终增强处理");
    }

    /**
     * 后置增强处理，在目标方法正常执行（不出现异常）后织入增强处理
     */
    @AfterReturning("findMethod()")
    public void afterAdvice(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Employee employee = (Employee) session.getAttribute("employee");
        //请求的IP
        String ip = request.getRemoteAddr();
        try {
            //*========控制台输出=========*//
            logger.debug("=====后置通知开始=====");
            logger.debug("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            //System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
            logger.debug("请求人:" + employee.getEmpName());
            logger.debug("请求IP:" + ip);

            //*========数据库日志=========*//
            AdminLog adminLog = new AdminLog();
            adminLog.setEmpId(employee.getEmpId());
            adminLog.setCompanyId(employee.getCompanyId());
            adminLog.setLogContent("访问首页");
            adminLog.setLogTime(new Date());
            //int row = adminLogMapper.insert(adminLog);
            //logger.debug("添加了" + row + "条日志管理记录");
            System.out.println("=====后置通知结束=====");
        } catch (Exception e) {
            //记录本地异常日志
            logger.error("==后置通知异常==");
            logger.error("异常信息:" + e.getMessage());
        }


    }

    /**
     * 异常增强处理
     */
    @AfterThrowing("findMethod()")
    public void throwsAdvice() {
        System.out.println("AfterThrowing异常后置增强处理");
    }






    @Around("findMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("进入环绕通知");
        Object object = pjp.proceed();// 执行该方法
        System.out.println("退出环绕通知");
        return object;
    }

}
