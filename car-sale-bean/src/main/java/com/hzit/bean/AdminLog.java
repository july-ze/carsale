package com.hzit.bean;

import java.util.Date;

public class AdminLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adminlog.log_Id
     *
     * @mbggenerated
     */
    private Integer logId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adminlog.emp_Id
     *
     * @mbggenerated
     */
    private Integer empId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adminlog.company_Id
     *
     * @mbggenerated
     */
    private Integer companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adminlog.log_Content
     *
     * @mbggenerated
     */
    private String logContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column adminlog.log_Time
     *
     * @mbggenerated
     */
    private Date logTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adminlog.log_Id
     *
     * @return the value of adminlog.log_Id
     *
     * @mbggenerated
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adminlog.log_Id
     *
     * @param logId the value for adminlog.log_Id
     *
     * @mbggenerated
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adminlog.emp_Id
     *
     * @return the value of adminlog.emp_Id
     *
     * @mbggenerated
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adminlog.emp_Id
     *
     * @param empId the value for adminlog.emp_Id
     *
     * @mbggenerated
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adminlog.company_Id
     *
     * @return the value of adminlog.company_Id
     *
     * @mbggenerated
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adminlog.company_Id
     *
     * @param companyId the value for adminlog.company_Id
     *
     * @mbggenerated
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adminlog.log_Content
     *
     * @return the value of adminlog.log_Content
     *
     * @mbggenerated
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adminlog.log_Content
     *
     * @param logContent the value for adminlog.log_Content
     *
     * @mbggenerated
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column adminlog.log_Time
     *
     * @return the value of adminlog.log_Time
     *
     * @mbggenerated
     */
    public Date getLogTime() {
        return logTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column adminlog.log_Time
     *
     * @param logTime the value for adminlog.log_Time
     *
     * @mbggenerated
     */
    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    @Override
    public String toString() {
        return "AdminLog{" +
                "logId=" + logId +
                ", empId=" + empId +
                ", companyId=" + companyId +
                ", logContent='" + logContent + '\'' +
                ", logTime=" + logTime +
                '}';
    }
}