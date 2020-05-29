package org.spring.springboot.service;

import org.spring.springboot.entity.City;

/**
 * 城市 业务逻辑 接口
 *
 * Created By QQ.y 2020/5/29
 */
public interface CityService {

    /**
     *  根据城市名称，查询城市对象
     *
     * @param cityName 城市名称
     */
    City findCityByCityName(String cityName);
}
