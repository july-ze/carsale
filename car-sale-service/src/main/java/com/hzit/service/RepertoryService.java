package com.hzit.service;

import com.hzit.bean.Repertory;

import java.util.List;

public interface RepertoryService {
    List<Repertory> findRepertoryByCompanyId(Integer companyId);
    List<Repertory> findByCompanyIdNotGroup(Integer companyId);

}
