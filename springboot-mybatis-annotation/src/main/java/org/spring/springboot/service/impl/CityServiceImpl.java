package org.spring.springboot.service.impl;

import org.spring.springboot.dao.CityDao;
import org.spring.springboot.entity.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市 业务逻辑层 接口实现类
 *
 * Created By QQ.y 2020/5/29
 */

//
@Service
public class CityServiceImpl implements CityService {

   @Autowired
   private CityDao cityDao;


    public City findCityByCityName(String cityName) {
        return cityDao.findCityByCityName(cityName);
    }
}
