package com.hzit.service.impl;

import com.hzit.bean.Customer;
import com.hzit.mapper.CustomerMapper;
import com.hzit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public List<Customer> findAllCustomerByCompanyId(Integer companyId) {
        return customerMapper.selectAllCustomerByCompanyId(companyId);
    }
}
