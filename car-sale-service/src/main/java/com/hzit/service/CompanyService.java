package com.hzit.service;


import com.hzit.bean.Company;

import java.util.List;

public interface CompanyService {
	List<Company> findAllCompany();
	Company findCompanyByObj(Company company);

}