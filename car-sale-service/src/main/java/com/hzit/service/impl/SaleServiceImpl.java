package com.hzit.service.impl;

import com.hzit.bean.Sale;
import com.hzit.mapper.SaleMapper;
import com.hzit.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleMapper saleMapper;

    @Override
    public List<Sale> findSaleByCompanyId(Integer companyId) {
        return saleMapper.selectByCompanyId(companyId);
    }
}
