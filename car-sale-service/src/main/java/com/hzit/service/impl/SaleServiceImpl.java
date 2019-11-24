package com.hzit.service.impl;

import com.hzit.bean.Employee;
import com.hzit.bean.Financing;
import com.hzit.bean.Repertory;
import com.hzit.bean.Sale;
import com.hzit.mapper.FinancingMapper;
import com.hzit.mapper.RepertoryMapper;
import com.hzit.mapper.SaleMapper;
import com.hzit.service.SaleService;
import com.hzit.util.MyConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired
    private SaleMapper saleMapper;
    @Autowired
    private RepertoryMapper repertoryMapper;
    @Autowired
    private FinancingMapper financingMapper;

    @Override
    public List<Sale> findSaleByCompanyId(Integer companyId) {
        return saleMapper.selectByCompanyId(companyId);
    }

    @Override
    public int addSale(Sale sale) {
        sale.setSaleTotalprice(sale.getSaleCurprice()*sale.getSaleNum());
        return saleMapper.insert(sale);
    }

    @Override
    public boolean updateSaleAndRepertoryAndInsertFinancing(Integer saleId, Integer companyId) {
        Sale sale = saleMapper.selectByPrimaryKey(saleId);
        sale.setSaleType(MyConst.HASPAYING);
        int row = saleMapper.updateByPrimaryKeySelective(sale);
        if(row<=0){
            return false;
        }
        Repertory repertory = repertoryMapper.selectByPrimaryKey(sale.getRepertoryId());
        repertory.setRepertoryNum(repertory.getRepertoryNum()-1);
        int i = repertoryMapper.updateByPrimaryKey(repertory);
        if(i<=0){
            return false;
        }
        Financing financing = new Financing();
        financing.setCompanyId(companyId);
        financing.setSaleId(sale.getSaleId());
        financing.setRepertoryId(sale.getRepertoryId());
        financing.setFinancingMoney(sale.getSaleTotalprice());
        financing.setFinancingTime(new Date());
        financing.setFinancingType(MyConst.INCOME);
        int n = financingMapper.insertSelective(financing);
        if(n<=0){
            return false;
        }

        return true;
    }
}
