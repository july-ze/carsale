package com.hzit.service.impl;

import com.hzit.bean.Company;
import com.hzit.mapper.CompanyMapper;
import com.hzit.service.CompanyService;
import com.hzit.util.SystemServiceLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<Company> findAllCompany() {
        return companyMapper.selectAllCompany();
    }

    @Override
    public Company findCompanyByObj(Company company) {
        return companyMapper.selectCompanyByObj(company);
    }
}