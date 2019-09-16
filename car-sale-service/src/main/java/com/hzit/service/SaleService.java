package com.hzit.service;


import com.hzit.bean.Sale;

import java.util.List;

public interface SaleService {
    /**
     * 根据公司id查询当前公司的销售记录
     * @param companyId
     * @return
     */
    List<Sale> findSaleByCompanyId(Integer companyId);

}
