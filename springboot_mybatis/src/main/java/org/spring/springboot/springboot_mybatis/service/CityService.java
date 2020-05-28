package org.spring.springboot.springboot_mybatis.service;

import org.spring.springboot.springboot_mybatis.entity.City;

/**
 * 城市业务逻辑接口类
 *
 * Created by QQ.y 20/5/27
 */
public interface CityService {

    /**
     * 根据城市名称，查询城市信息
     * @param cityName
     */
    City findByName(String cityName);
}

