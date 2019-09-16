package com.hzit.controller;

import com.hzit.bean.Customer;
import com.hzit.bean.Employee;
import com.hzit.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private static Logger logger = LogManager.getLogger(CustomerController.class);


    @RequestMapping("/list")
    @ResponseBody
    public List<Customer> findCustomers(HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee==null){
            employee = new Employee();
        }
        List<Customer> customerList = customerService.findAllCustomerByCompanyId(employee.getCompanyId());
        return customerList;
    }

}
