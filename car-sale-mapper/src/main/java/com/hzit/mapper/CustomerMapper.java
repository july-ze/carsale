package com.hzit.mapper;

import com.hzit.bean.Customer;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer customerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int insert(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int insertSelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    Customer selectByPrimaryKey(Integer customerId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Customer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Customer record);

    List<Customer> selectAllCustomerByCompanyId(@Param(value = "companyId") Integer companyId);
}