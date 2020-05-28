package org.spring.springboot.springboot_mybatis.service.impl;

import org.spring.springboot.springboot_mybatis.dao.CityDao;
import org.spring.springboot.springboot_mybatis.entity.City;
import org.spring.springboot.springboot_mybatis.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑层接口实现类
 *
 * Created by QQ.y 20/5/27
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findByName(String cityName) {
        return cityDao.findByName(cityName);
    }
}
