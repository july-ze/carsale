package com.hzit.controller;

import com.hzit.bean.Car;
import com.hzit.bean.CarBrand;
import com.hzit.bean.CarOrder;
import com.hzit.bean.Employee;
import com.hzit.service.CarOrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class CarOrderController {
    @Autowired
    private CarOrderService carOrderService;
    private static Logger logger = LogManager.getLogger(CarOrderController.class);

    @RequestMapping("/getAllCarBrand")
    @ResponseBody
    public List<CarBrand> getAllCarBrand(){
        List<CarBrand> carbrandList = carOrderService.findAllCarBrand();
        return carbrandList;
    }
    @RequestMapping("/getAllCarSeries")
    @ResponseBody
    public CarBrand getAllCarSeries(Integer brandId){
        CarBrand carBrand = carOrderService.findCarBrandById(brandId);
        return carBrand;
    }
    @RequestMapping("/getAllCar")
    @ResponseBody
    public List<Car> getAllCar(Integer seriesId){
        List<Car> carList = carOrderService.findCarBySeriesId(seriesId);
        return carList;
    }

    @RequestMapping("/getCarPriceById")
    @ResponseBody
    public Car getCarPriceById(Integer carId){
        return carOrderService.findCarByCarId(carId);
    }

    @RequestMapping("/insertOrder")
    public String insertOrder(CarOrder carOrder, double carPrice, HttpSession session){
        Employee employee = (Employee)session.getAttribute("employee");
        if(employee==null){
            logger.debug("用户未登录，跳转至登录界面");
            return "redirect:/jsp/login.jsp";
        }
        carOrder.setOrderTotalPrice(carPrice*carOrder.getOrderNum());
        carOrder.setCompanyId(employee.getCompanyId());
        carOrderService.insertOrder(carOrder);
        return "redirect:/repertory/getAllRepertory";
    }



}
