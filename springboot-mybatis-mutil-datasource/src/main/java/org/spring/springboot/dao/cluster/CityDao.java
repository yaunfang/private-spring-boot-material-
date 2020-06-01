package org.spring.springboot.dao.cluster;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.spring.springboot.entity.City;

/**
 * 城市 dao 接口类
 *
 * Created By QQ.y 2020/5/29
 */
@Mapper
public interface CityDao {

    /**
     * 通过城市名称查找城市对象
     * @param cityName
     * @return City
     */
    City findByName(@Param("cityName")String cityName);
}
