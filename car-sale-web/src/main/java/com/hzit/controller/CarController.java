package com.hzit.controller;

import com.hzit.bean.Car;
import com.hzit.service.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;
    private static Logger logger = LogManager.getLogger(CarController.class);


    @RequestMapping("/list")
    @ResponseBody
    public List<Car> findCustomers(HttpSession session){
        logger.debug("开始查询所有汽车信息");
        List<Car> carList = carService.findAllCar();
        logger.debug("查询所有汽车信息方法结束");
        return carList;
    }

}
