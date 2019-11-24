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

    /**
     * 添加销售记录
     * @param sale
     * @return
     */
    int addSale(Sale sale);

    /**
     * 客户付款
     * 根据saleId修改销售记录的付款记录
     * 同时修改该种车辆的库存数量并添加财务收款信息
     * @param saleId
     * @return
     */
    boolean updateSaleAndRepertoryAndInsertFinancing(Integer saleId,Integer companyId);
}
