package com.hzit.controller;

import com.hzit.bean.Employee;
import com.hzit.bean.Sale;
import com.hzit.service.SaleService;
import com.hzit.util.MyConst;
import com.hzit.util.SystemControllerLog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    private static Logger logger = LogManager.getLogger(LoginController.class);

    @RequestMapping("/list")
    @SystemControllerLog(description = "查看销售信息")
    public String getSaleList(HttpSession session, Model model){
        logger.debug("根据公司Id查询所有销售信息方法开始");
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee==null){
            logger.debug("用户未登录，跳转至登录界面");
           return "redirect:/jsp/login.jsp";
        }
        List<Sale> saleList = saleService.findSaleByCompanyId(employee.getCompanyId());
        model.addAttribute("saleList",saleList);
        if(employee.getPositionId()== MyConst.ADMINPOSITION){
            logger.debug("用户角色为经理，跳转至AdminSaleList.jsp，方法结束");
            return "AdminSaleList";
        }else{
            logger.debug("用户角色为销售，跳转至EmpSaleList.jsp，方法结束");
            return "EmpSaleList";
        }

    }

}
