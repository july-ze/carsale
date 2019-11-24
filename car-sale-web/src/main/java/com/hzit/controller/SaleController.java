package com.hzit.controller;

import com.hzit.bean.CarSeries;
import com.hzit.bean.Employee;
import com.hzit.bean.Sale;
import com.hzit.service.CarSeriesService;
import com.hzit.service.EmployeeService;
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

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;
    @Autowired
    private CarSeriesService carSeriesService;
    @Autowired
    private EmployeeService employeeService;

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
    @RequestMapping("/getCarSeriesById")
    @ResponseBody
    public Map<String,CarSeries> getCarSeriesById(Integer seriesId){
        logger.debug("根据车系Id查询车系及品牌的方法开始");
        Map<String,CarSeries> map = new HashMap<>();
        CarSeries carSeries = carSeriesService.findBySeriesId(seriesId);
        map.put("carseriesById",carSeries);
        logger.debug("根据车系Id查询车系及品牌的方法结束"+carSeries);
        return map;
    }


    @RequestMapping("/getAllEmpByCompanyId")
    @ResponseBody
    public Map<String,List<Employee>> getAllEmpByCompanyId(HttpSession session){
        logger.debug("根据公司Id查询该公司销售员工的方法开始");
        Map<String,List<Employee>> map = new HashMap<>();
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee==null){
            logger.debug("用户未登录，跳转至登录界面");
            return null;
        }
        List<Employee> employeeList = employeeService.findEmployeeByCompanyId(employee.getCompanyId());
        map.put("employeeList",employeeList);
        logger.debug("根据公司Id查询该公司销售员工的方法结束"+employeeList);
        return map;
    }

    @RequestMapping("/insertSale")
    @SystemControllerLog(description = "添加销售登记")
    public String insertSale(Sale sale){
        logger.debug("添加sale的方法开始");
        int row = saleService.addSale(sale);
        logger.debug("添加sale的方法结束！row="+row);
        return "redirect:/sale/list";
    }


    @RequestMapping("/updateSale")
    @SystemControllerLog(description = "车辆销售付款操作")
    public String updateSale(Integer saleId,HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee==null){
            logger.debug("用户未登录，跳转至登录界面");
            return "redirect:/jsp/login.jsp";
        }
        logger.debug("销售情况付款方法开始");
        boolean b = saleService.updateSaleAndRepertoryAndInsertFinancing(saleId, employee.getCompanyId());
        if (b==false){
            logger.debug("销售情况付款方法service层出现异常");
            return null;
        }
        logger.debug("销售情况付款方法结束！");
        return "redirect:/sale/list";
    }

}
