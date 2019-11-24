package com.hzit.service.impl;

import com.hzit.bean.Car;
import com.hzit.mapper.CarMapper;
import com.hzit.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarMapper carMapper;

    @Override
    public List<Car> findAllCar() {
        return carMapper.selectAllCar();
    }
}
