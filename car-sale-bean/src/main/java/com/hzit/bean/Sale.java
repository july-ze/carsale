package com.hzit.bean;

import com.hzit.util.MyConst;

import java.math.BigDecimal;
import java.util.Date;

public class Sale {
    private Integer saleId;
    private Integer customerId;
    private Integer carId;
    private Integer empId;
    private Integer companyId;
    private double saleCurprice;
    private Integer saleNum;
    private String saleType;
    private double saleTotalprice;
    private Date saleTime;
    private Employee employee;
    private Customer customer;
    private Car car;
    private Integer repertoryId;

    public String getSaleTypeFormat() {
        String str = null;
        if (MyConst.NOTPAYING.equals(saleType)){
            str = "未付款";
        } else if (MyConst.HASPAYING.equals(saleType)){
            str = "已付款";
        }
        return str;
    }

    public Integer getRepertoryId() {
        return repertoryId;
    }

    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", customerId=" + customerId +
                ", carId=" + carId +
                ", empId=" + empId +
                ", companyId=" + companyId +
                ", saleCurprice=" + saleCurprice +
                ", saleNum=" + saleNum +
                ", saleType='" + saleType + '\'' +
                ", saleTotalprice=" + saleTotalprice +
                ", saleTime=" + saleTime +
                ", employee=" + employee +
                ", customer=" + customer +
                ", car=" + car +
                '}';
    }

    public double getSaleCurprice() {
        return saleCurprice;
    }

    public void setSaleCurprice(double saleCurprice) {
        this.saleCurprice = saleCurprice;
    }

    public double getSaleTotalprice() {
        return saleTotalprice;
    }

    public void setSaleTotalprice(double saleTotalprice) {
        this.saleTotalprice = saleTotalprice;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }


    public Integer getCustomerId() {
        return customerId;
    }


    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getCompanyId() {
        return companyId;
    }


    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }


    public Integer getSaleNum() {
        return saleNum;
    }


    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }


    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType == null ? null : saleType.trim();
    }


    public Date getSaleTime() {
        return saleTime;
    }

    public void setSaleTime(Date saleTime) {
        this.saleTime = saleTime;
    }
}