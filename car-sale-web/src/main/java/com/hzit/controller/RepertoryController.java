package com.hzit.controller;

import com.hzit.bean.Car;
import com.hzit.bean.Employee;
import com.hzit.bean.Repertory;
import com.hzit.service.CarService;
import com.hzit.service.RepertoryService;
import com.hzit.util.MyConst;
import com.hzit.util.SystemControllerLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/repertory")
public class RepertoryController {
    @Autowired
    private RepertoryService repertoryService;
    private static Logger logger = LogManager.getLogger(RepertoryController.class);


    @RequestMapping("/list")
    @ResponseBody
    public List<Repertory> findCustomers(HttpSession session){
        logger.debug("查询所有汽车库存信息方法开始");
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee==null){
            return null;
        }
        logger.debug("查询所有汽车库存信息方法,用户已登录");
        List<Repertory> repertoryList = repertoryService.findRepertoryByCompanyId(employee.getCompanyId());
        logger.debug("查询所有汽车库存信息方法结束"+repertoryList);
        return repertoryList;
    }

    @RequestMapping("/getAllRepertory")
    @SystemControllerLog(description = "查看库存信息")
    public String getAllRepertory(HttpSession session, Model model){
        logger.debug("根据公司查询所有汽车库存信息方法开始");
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee==null){
            logger.debug("根据公司查询所有汽车库存信息方法====用户未登录，跳转登录界面");
            return "redirect:/jsp/login.jsp";
        }
        logger.debug("根据公司查询所有汽车库存信息方法,用户已登录");
        List<Repertory> repertoryList = repertoryService.findByCompanyIdNotGroup(employee.getCompanyId());
        model.addAttribute("repertoryList",repertoryList);
        logger.debug("查询所有汽车库存信息方法结束"+repertoryList);
        if(employee.getPositionId()== MyConst.ADMINPOSITION){
            return "AdminRepertoryList";
        }else {
            return "EmpRepertoryList";
        }

    }



}
