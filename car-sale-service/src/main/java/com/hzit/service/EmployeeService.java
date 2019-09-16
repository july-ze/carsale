package com.hzit.service;


import com.hzit.bean.Employee;

import java.util.List;

public interface EmployeeService {
	/**
	 * 登录成功，跳转主界面
	 * @param employee
	 * @return
	 */
	String goMain(Employee employee);

	/**
	 * 查询员工信息
	 * @param employee
	 * @return
	 */
	Employee findEmployeeByObj(Employee employee);

	/**
	 * 注册
	 * @param employee
	 * @return
	 */
	int addEmployee(Employee employee);
}