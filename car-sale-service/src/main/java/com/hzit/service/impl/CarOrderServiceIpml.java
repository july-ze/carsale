package com.hzit.service.impl;

import com.hzit.bean.Car;
import com.hzit.bean.CarBrand;
import com.hzit.bean.CarOrder;
import com.hzit.bean.CarSeries;
import com.hzit.mapper.CarBrandMapper;
import com.hzit.mapper.CarMapper;
import com.hzit.mapper.CarOrderMapper;
import com.hzit.mapper.CarSeriesMapper;
import com.hzit.service.CarOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarOrderServiceIpml implements CarOrderService {
    @Autowired
    private CarBrandMapper carBrandMapper;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private CarOrderMapper carOrderMapper;


    @Override
    public List<CarBrand> findAllCarBrand() {
        return carBrandMapper.selectAllBand();
    }

    @Override
    public List<Car> findCarBySeriesId(Integer seriesId) {
        return carMapper.selectBySeriesId(seriesId);
    }

    @Override
    public CarBrand findCarBrandById(Integer brandId) {
        return carBrandMapper.selectById(brandId);
    }

    @Override
    public Car findCarByCarId(Integer carId) {
        return carMapper.selectByPrimaryKey(carId);
    }

    @Override
    public int insertOrder(CarOrder carOrder) {
        return carOrderMapper.insert(carOrder);
    }
}
