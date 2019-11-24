package com.hzit.service.impl;

import com.hzit.bean.Employee;
import com.hzit.mapper.EmployeeMapper;
import com.hzit.service.EmployeeService;
import com.hzit.util.MyConst;
import com.hzit.util.SystemServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    @SystemServiceLog(description = "登录成功，访问首页")
    public String goMain(Employee employee) {

        String path = "";
        Integer positionId = employee.getPositionId();
        if(MyConst.ADMINPOSITION==positionId){
            path = "AdminMain";
        }else if(MyConst.EMPPOSITION==positionId){
            path = "EmpMain";
        }
        return path;
    }

    @Override
    public Employee findEmployeeByObj(Employee employee) {
        return employeeMapper.selectEmployeeByObj(employee);
    }

    @Override
    public int addEmployee(Employee employee) {
        return employeeMapper.insert(employee);
    }

    @Override
    public List<Employee> findEmployeeByCompanyId(Integer companyId) {
        return employeeMapper.selectEmployeeByCompanyId(companyId);
    }


}