package org.spring.springboot.controller;

import org.spring.springboot.entity.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 城市 控制层
 *
 * Created By QQ.y 2020/5/29
 */
@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "api/findcitybycityname",method = RequestMethod.GET)
    public City findCityByCityName(@RequestParam(value = "cityName",required = true)String cityName){
        return cityService.findCityByCityName(cityName);
    }
}
