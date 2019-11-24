package com.hzit.bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Repertory {
    private Integer repertoryId;

    private Integer carId;

    private Car car;

    private Integer companyId;


    private BigDecimal purchasePrice;

    private Date inTime;


    private Integer repertoryNum;

    public String getInTimeFormat() {
        return new SimpleDateFormat("yyyy/MM/dd").format(inTime);
    }

    public Integer getRepertoryId() {
        return repertoryId;
    }


    public void setRepertoryId(Integer repertoryId) {
        this.repertoryId = repertoryId;
    }

    public Integer getCarId() {
        return carId;
    }


    public void setCarId(Integer carId) {
        this.carId = carId;
    }


    public Integer getCompanyId() {
        return companyId;
    }


    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }


    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }


    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Date getInTime() {
        return inTime;
    }


    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }


    public Integer getRepertoryNum() {
        return repertoryNum;
    }

    public void setRepertoryNum(Integer repertoryNum) {
        this.repertoryNum = repertoryNum;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Repertory{" +
                "repertoryId=" + repertoryId +
                ", carId=" + carId +
                ", car=" + car +
                ", companyId=" + companyId +
                ", purchasePrice=" + purchasePrice +
                ", inTime=" + inTime +
                ", repertoryNum=" + repertoryNum +
                '}';
    }
}