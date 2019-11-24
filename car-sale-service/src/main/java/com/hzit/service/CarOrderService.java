package com.hzit.service;

import com.hzit.bean.Car;
import com.hzit.bean.CarBrand;
import com.hzit.bean.CarOrder;
import com.hzit.bean.CarSeries;

import java.util.List;

public interface CarOrderService {
    List<CarBrand> findAllCarBrand();

    List<Car> findCarBySeriesId(Integer seriesId);

    CarBrand findCarBrandById(Integer brandId);

    Car findCarByCarId(Integer carId);

    int insertOrder(CarOrder carOrder);
}
