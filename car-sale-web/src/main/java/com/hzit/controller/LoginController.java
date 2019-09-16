package com.hzit.controller;

import com.hzit.bean.Company;
import com.hzit.bean.Employee;
import com.hzit.service.CompanyService;
import com.hzit.service.EmployeeService;
import com.hzit.util.PhoneMessageUtil;
import com.hzit.util.SystemControllerLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private CompanyService companyService;
    private static Logger logger = LogManager.getLogger(LoginController.class);
    PhoneMessageUtil phoneMessageUtil = new PhoneMessageUtil();

    /**
     * 验证公司名称
     * @param company
     * @return
     */
    @RequestMapping("/isExistCompanyName")
    @ResponseBody
    public Map<String, String> isExistCompanyName(Company company){

        Map<String,String> map = new HashMap<String, String>();

        Company companyByObj = companyService.findCompanyByObj(company);
        if (companyByObj == null){

            map.put("resultName","false");
        } else {

            map.put("resultName","true");
        }


        return map;
    }

    /**
     * 验证输入的员工姓名是否存在
     * @param employee
     * @return
     */
    @RequestMapping("/isExistEmpName")
    @ResponseBody
    public Map<String,String > isExistEmpName(Employee employee){
        logger.debug("开始验证员工姓名");
        Employee employeeByObj = employeeService.findEmployeeByObj(employee);
        Map<String,String> map = new HashMap<>();
        if(employeeByObj!=null){
            logger.debug("员工姓名存在，返回true");
            map.put("resultName","true");
        }else {
            logger.debug("员工姓名不存在，返回false");
            map.put("resultName","false");
        }

        return map;
    }

    /**
     * 根据用户填入的公司及电话信息来验证该用户输入的电话是否正确
     * @param employee
     * @return
     */
    @RequestMapping("/isExistEmpPhone")
    @ResponseBody
    public Map<String,String> isExistEmpPhone(Employee employee){
        logger.debug("开始验证员工电话");
        Map<String,String> map = new HashMap<>();
        Employee employeeByObj = employeeService.findEmployeeByObj(employee);
        if(employeeByObj!=null){
           logger.debug("员工电话验证正确");
            map.put("resultName","true");
        }else{
           logger.debug("员工电话输入不正确");
            map.put("resultName","false");
        }
        return map;
    }

    @RequestMapping("/isLoginSuccess")
    @ResponseBody
    public Map<String,String> isLoginSuccess(Employee employee, HttpSession session){
        logger.debug("开始验证员工登录信息");
        Map<String,String> map = new HashMap<>();
        Employee employeeByObj = employeeService.findEmployeeByObj(employee);
        if(employeeByObj!=null){
            logger.debug("员工登录信息验证正确，可登录");
            session.setAttribute("employee",employeeByObj);
            map.put("resultLogin","true");
        }else{
            logger.debug("员工登录信息验证失败");
            map.put("resultLogin","false");
        }
       logger.debug("员工登录信息验证结束");
        return map;
    }

    /**
     * 权限管理，跳去主界面
     * @param session
     * @return
     */
    @RequestMapping("/goMain")
    public ModelAndView goMainJsp(HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        ModelAndView modelAndView = new ModelAndView();
        if(employee==null){
            logger.debug("无用户登录，跳转至登录界面");
            modelAndView.setViewName("login");
        }else {
            logger.debug("开始根据权限跳转不同主界面");
            String path = employeeService.goMain(employee);
            modelAndView.setViewName(path);
            logger.debug("跳转界面方法结束");
        }

        return modelAndView;
    }

    @RequestMapping("/companyList")
    @ResponseBody
    public List<Company> findAllCompany(){
        logger.debug("查询所有公司");
        List<Company> companyList = companyService.findAllCompany();
        return companyList;
    }


    /**
     * @description: 给注册手机发送短信验证码
     * @param: empPhoneNumber：员工注册手机号码
     * @return: Map<String, String>
     * @author: july
     * @date: 2019年9月15日15:18:35
    **/
    @RequestMapping("/sendPhoneMesseger")
    @ResponseBody
    public Map<String, String> sendPhoneMesseger(String empPhoneNumber){
        logger.debug("开始--发送手机短信的方法");
        Map<String,String> map = new HashMap<String, String>();

        String authcode = phoneMessageUtil.genRandomNum(4);
        logger.debug("手机验证码,生成验证码:"+authcode);

        if(phoneMessageUtil.sandMassage(authcode,empPhoneNumber)){
            logger.debug("验证码发送成功,发送号码:"+empPhoneNumber);
            map.put("resultRegister",authcode);
        }else{
            logger.debug("验证码发送失败,发送号码:"+empPhoneNumber);
            //map.put("resultRegister","false");
            map.put("resultRegister",authcode);
        }

        logger.debug("结束--发送手机短信的方法");
        return map;
    }

    /**
     * 注册用户
     * @param employee
     * @return
     */
    @RequestMapping("/isRegisterSuccess")
    @SystemControllerLog(description = "新用户注册")
    @ResponseBody
    public Map<String,String> isRegisterSuccess(Employee employee){
        logger.debug("注册方法开始");
        Map<String,String> map = new HashMap<String, String>();
        int row = employeeService.addEmployee(employee);
        if(row>0){
            logger.debug("用户"+employee.getEmpName()+"注册成功");
            map.put("resultRegister","true");
        }else {
            logger.debug("用户"+employee.getEmpName()+"注册失败");
            map.put("resultRegister","false");
        }
        logger.debug("注册方法结束");
        return map;
    }

}