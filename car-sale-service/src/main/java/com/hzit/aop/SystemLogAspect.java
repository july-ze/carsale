package com.hzit.aop;

import com.hzit.bean.AdminLog;
import com.hzit.bean.Employee;
import com.hzit.mapper.AdminLogMapper;
import com.hzit.mapper.EmployeeMapper;
import com.hzit.util.SystemControllerLog;
import com.hzit.util.SystemServiceLog;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class SystemLogAspect {
    //注入Service用于把日志保存数据库
    @Resource
    private AdminLogMapper adminLogMapper;
    @Resource
    private EmployeeMapper employeeMapper;
    private static Logger logger = LogManager.getLogger(SystemLogAspect.class);

    /**
     * 定义service层注解切点
     */
    @Pointcut("@annotation(com.hzit.util.SystemServiceLog)")
    public void serviceAspect() {

    }

    /**
     * 定义controller层注解切点
     */
    @Pointcut("@annotation(com.hzit.util.SystemControllerLog)")
    public void controllerAspect() {

    }

    /**
     * service层
     * @param joinPoint
     */
    @AfterReturning("serviceAspect()")
    public void serviceAfterAdvice(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Employee employee = (Employee) session.getAttribute("employee");
        //请求的IP
        String ip = request.getRemoteAddr();
        try {
            //*========控制台输出=========*//
            System.out.println("=====前置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
            System.out.println("请求人:" + employee.getEmpName());
            System.out.println("请求IP:" + ip);
            //*========数据库日志=========*//
            AdminLog adminLog = new AdminLog();
            adminLog.setEmpId(employee.getEmpId());
            adminLog.setCompanyId(employee.getCompanyId());
            adminLog.setLogContent(getServiceMthodDescription(joinPoint));
            adminLog.setLogTime(new Date());
            int row = adminLogMapper.insert(adminLog);
            logger.debug("添加了" + row + "条日志管理记录");
            System.out.println("=====后置通知结束=====");
        } catch (Exception e) {
            //记录本地异常日志
            e.printStackTrace();
            logger.error("----运行后置增强异常----日志管理------");
            logger.error("异常信息:{}" + e.getMessage());
        }
    }

    /**
     * controller层
     * @param joinPoint
     */
    @AfterReturning("controllerAspect()")
    public void controllerAfterAdvice(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //读取session中的用户
        Employee employee = (Employee) session.getAttribute("employee");
        String methodName = joinPoint.getSignature().getName();
        if(employee==null || methodName.equals("isRegisterSuccess")){
            try {
                Map<String, Object> map = SystemLogAspect.getFieldsName(joinPoint);
                Employee employee1 = (Employee)map.get("employee");
                employee=employeeMapper.selectEmployeeByObj(employee1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        //请求的IP
        String ip = request.getRemoteAddr();
        try {
            //*========控制台输出=========*//
            System.out.println("=====后置通知开始=====");
            System.out.println("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            System.out.println("方法描述:" + getControllerMethodDescription(joinPoint));
            System.out.println("请求人:" + employee.getEmpName());
            System.out.println("请求IP:" + ip);
            //*========数据库日志=========*//
            AdminLog adminLog = new AdminLog();
            adminLog.setEmpId(employee.getEmpId());
            adminLog.setCompanyId(employee.getCompanyId());
            adminLog.setLogContent(getControllerMethodDescription(joinPoint));
            adminLog.setLogTime(new Date());
            int row = adminLogMapper.insert(adminLog);
            logger.debug("添加了" + row + "条日志管理记录");
            System.out.println("=====后置通知结束=====");
        } catch (Exception e) {
            //记录本地异常日志
            e.printStackTrace();
            logger.error("----运行后置增强异常----日志管理------");
            logger.error("异常信息:{}" + e.getMessage());
        }
    }
    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getServiceMthodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SystemControllerLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

    /**
     * 获取AOP监控的方法的参数名及参数值
     * @param joinPoint
     * @return
     * @throws ClassNotFoundException
     * @throws NoSuchMethodException
     */
    private static Map<String, Object> getFieldsName(JoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        // 参数值
        Object[] args = joinPoint.getArgs();
        Class<?>[] classes = new Class[args.length];

        for (int k = 0; k < args.length; k++) {
            // 对于接受参数中含有MultipartFile，ServletRequest，ServletResponse类型的特殊处理，我这里是直接返回了null。（如果不对这三种类型判断，会报异常）
            if (args[k] instanceof MultipartFile || args[k] instanceof ServletRequest || args[k] instanceof ServletResponse) {
                return null;
            }
            if (!args[k].getClass().isPrimitive()) {
                // 当方法参数是基础类型，但是获取到的是封装类型的就需要转化成基础类型
                String result = args[k].getClass().getName();
                Class s = map.get(result);
                // 当方法参数是封装类型
                //Class s = args[k].getClass();
                classes[k] = s == null ? args[k].getClass() : s;
            }

        }
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        // 获取指定的方法，第二个参数可以不传，但是为了防止有重载的现象，还是需要传入参数的类型
        Method method = Class.forName(classType).getMethod(methodName, classes);
        // 参数名
        String[] parameterNames = pnd.getParameterNames(method);
        // 通过map封装参数和参数值
        Map<String, Object> paramMap = new HashMap();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }
        return paramMap;
    }

    private static HashMap<String, Class> map = new HashMap<String, Class>() {
        {
            put("java.lang.Integer", int.class);
            put("java.lang.Double", double.class);
            put("java.lang.Float", float.class);
            put("java.lang.Long", long.class);
            put("java.lang.Short", short.class);
            put("java.lang.Boolean", boolean.class);
            put("java.lang.Char", char.class);
        }
    };

//    /**
//     * 前置增强
//     */
//    @Before("serviceAspect()")
//    public void beforeService() {
//        System.out.println("测试service层注解aop是否有效，前置增强处理");
//    }
//    /**
//     * 前置增强
//     */
//    @Before("controllerAspect()")
//    public void beforeController() {
//        System.out.println("测试controller层注解aop是否有效，前置增强处理");
//    }

//    /**
//     * 前置增强
//     */
//    @After("findMethod()")
//    public void finallyAfterAdvice() {
//        System.out.println("TestAspectAfter最终增强处理");
//    }
//

//
//    /**
//     * 异常增强处理
//     */
//    @AfterThrowing("findMethod()")
//    public void throwsAdvice() {
//        System.out.println("TestAspect==AfterThrowing异常后置增强处理");
//    }

//
//    @Around("findMethod()")
//    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
//        System.out.println("进入环绕通知");
//        Object object = pjp.proceed();// 执行该方法
//        System.out.println("退出环绕通知");
//        return object;
//    }

//    /**
//     * 异常通知 用于拦截service层记录异常日志
//     *
//     * @param joinPoint
//     * @param e
//     */
//    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
//    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
//        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
//        HttpSession session = request.getSession();
//        //读取session中的用户
//        Employee employee = (Employee) session.getAttribute("employee");
//        //获取请求ip
//        String ip = request.getRemoteAddr();
//        //获取用户请求方法的参数并序列化为JSON格式字符串
//        String params = "";
//        if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
//            for (int i = 0; i < joinPoint.getArgs().length; i++) {
//                params += JSON.toJSONString(joinPoint.getArgs()[i]) + ";";
//            }
//        }
//        try {
//              /*========控制台输出=========*/
//            System.out.println("=====异常通知开始=====");
//            System.out.println("异常代码:" + e.getClass().getName());
//            System.out.println("异常信息:" + e.getMessage());
//            System.out.println("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
//            System.out.println("方法描述:" + getServiceMthodDescription(joinPoint));
//            System.out.println("请求人:" + employee.getEmpName());
//            System.out.println("请求IP:" + ip);
//            System.out.println("请求参数:" + params);
//               /*==========数据库日志=========*/
//            adminLog.setEmpId(employee.getEmpId());
//            adminLog.setCompanyId(employee.getCompanyId());
//            adminLog.setLogContent(getControllerMethodDescription(joinPoint));
//            adminLog.setLogTime(new Date());
//            int row = adminLogMapper.insert(adminLog);
//            System.out.println("=====异常通知结束=====");
//        } catch (Exception ex) {
//            //记录本地异常日志
//            logger.error("==异常通知异常==");
//            logger.error("异常信息:{}" + ex.getMessage());
//        }
//         /*==========记录本地异常日志==========*/
//        logger.error("异常方法:" + joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName());
//        logger.error("异常代码" + e.getClass().getName());
//        logger.error("异常信息:" + e.getMessage());
//        logger.error("参数:" + params);
//    }


}
