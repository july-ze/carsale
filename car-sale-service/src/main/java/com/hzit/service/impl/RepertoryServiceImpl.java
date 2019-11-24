package com.hzit.service.impl;

import com.hzit.bean.Repertory;
import com.hzit.mapper.RepertoryMapper;
import com.hzit.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepertoryServiceImpl implements RepertoryService{
    @Autowired
    private RepertoryMapper repertoryMapper;
    @Override
    public List<Repertory> findRepertoryByCompanyId(Integer companyId) {
        return repertoryMapper.selectByCompanyId(companyId);
    }

    @Override
    public List<Repertory> findByCompanyIdNotGroup(Integer companyId) {
        return repertoryMapper.selectByCompanyIdNotGroup(companyId);
    }
}
