package com.hzit.service.impl;

import com.hzit.bean.CarSeries;
import com.hzit.mapper.CarSeriesMapper;
import com.hzit.service.CarSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarSeriesServiceImpl implements CarSeriesService {
    @Autowired
    private CarSeriesMapper carSeriesMapper;
    @Override
    public CarSeries findBySeriesId(Integer seriesId) {
        return carSeriesMapper.selectBySeriesId(seriesId);
    }
}
