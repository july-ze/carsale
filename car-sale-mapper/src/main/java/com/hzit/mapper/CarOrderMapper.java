package com.hzit.mapper;

import com.hzit.bean.CarOrder;

public interface CarOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carorder
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carorder
     *
     * @mbggenerated
     */
    int insert(CarOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carorder
     *
     * @mbggenerated
     */
    int insertSelective(CarOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carorder
     *
     * @mbggenerated
     */
    CarOrder selectByPrimaryKey(Integer orderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carorder
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CarOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table carorder
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CarOrder record);
}