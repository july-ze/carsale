package com.hzit.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Financing {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column financing.financing_Id
     *
     * @mbggenerated
     */
    private Integer financingId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column financing.sale_Id
     *
     * @mbggenerated
     */
    private Integer saleId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column financing.repertory_Id
     *
     * @mbggenerated
     */
    private Integer repertoryId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column financing.company_Id
     *
     * @mbggenerated
     */
    private Integer companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column financing.financing_Money
     *
     * @mbggenerated
     */
    private double financingMoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column financing.financing_Type
     *
     * @mbggenerated
     */
    private String financingType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column financing.financing_Time
     *
     * @mbggenerated
     */
    private Date financingTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column financing.financing_Id
     *
     * @return the value of financing.financing_Id
     *
     * @mbggenerated
     */
    public Integer getFinancingId() {
        return financingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column financing.financing_Id
     *
     * @param financingId the value for financing.financing_Id
     *
     * @mbggenerated
     */
    public void setFinancingId(Integer financingId) {
        this.financingId = financingId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column financing.sale_Id
     *
     * @return the value of financing.sale_Id
     *
     * @mbggenerated
     */
    public Integer getSaleId() {
        return saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column financing.sale_Id
     *
     * @param saleId the value for financing.sale_Id
     *
     * @mbggenerated
     */
    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column financing.repertory_Id
     *
     * @return the value of financing.repertory_Id
     *
     * @mbggenerated
     */
    public Integer getRepertoryId() {
        return repertoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column financing.repertory_Id
     *
     * @param repertoryId the value for financing.repertory_Id
     *
     * @mbggenerated
     */
    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column financing.company_Id
     *
     * @return the value of financing.company_Id
     *
     * @mbggenerated
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column financing.company_Id
     *
     * @param companyId the value for financing.company_Id
     *
     * @mbggenerated
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column financing.financing_Money
     *
     * @return the value of financing.financing_Money
     *
     * @mbggenerated
     */
    public double getFinancingMoney() {
        return financingMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column financing.financing_Money
     *
     * @param financingMoney the value for financing.financing_Money
     *
     * @mbggenerated
     */
    public void setFinancingMoney(double financingMoney) {
        this.financingMoney = financingMoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column financing.financing_Type
     *
     * @return the value of financing.financing_Type
     *
     * @mbggenerated
     */
    public String getFinancingType() {
        return financingType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column financing.financing_Type
     *
     * @param financingType the value for financing.financing_Type
     *
     * @mbggenerated
     */
    public void setFinancingType(String financingType) {
        this.financingType = financingType == null ? null : financingType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column financing.financing_Time
     *
     * @return the value of financing.financing_Time
     *
     * @mbggenerated
     */
    public Date getFinancingTime() {
        return financingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column financing.financing_Time
     *
     * @param financingTime the value for financing.financing_Time
     *
     * @mbggenerated
     */
    public void setFinancingTime(Date financingTime) {
        this.financingTime = financingTime;
    }
}