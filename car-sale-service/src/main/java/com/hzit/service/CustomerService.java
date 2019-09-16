package com.hzit.service;

import com.hzit.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomerByCompanyId(Integer companyId);
}
