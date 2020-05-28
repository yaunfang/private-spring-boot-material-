package org.spring.springboot.springboot_mybatis.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.springboot_mybatis.entity.City;

/**
 * 城市 Dao 接口类
 *
 * Created by QQ.y 20/5/27
 * */

public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */

    City findByName(@Param("cityName") String cityName);
}
