package org.spring.springboot.springboot_mybatis.controller;

import org.spring.springboot.springboot_mybatis.entity.City;
import org.spring.springboot.springboot_mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 控制层
 *
 *Created by QQ.y 20/5/27
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "api/city",method = RequestMethod.GET)
    public City findByName(@RequestParam(value = "cityName",required = true) String cityName){
        return cityService.findByName(cityName);
    }
}
