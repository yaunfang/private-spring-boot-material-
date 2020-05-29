package org.spring.springboot.dao;

import org.apache.ibatis.annotations.*;
import org.spring.springboot.entity.City;

/**
 * 城市 Dao 接口类
 *
 * Created By QQ.y 2020/5/29
 */

@Mapper     //标识为 MapperMyBatis 的
public interface CityDao {

    /**
     *  根据城市名称，查询城市对象
     *
     * @param cityName 城市名称
     * @return City 城市对象
     */
    @Select("SELECT * FROM CITY")
    // 返回Map结果集
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "provinceId",column = "province_id"),
            @Result(property = "cityName",column = "city_name"),
            @Result(property = "description",column = "description")
    })
    City findCityByCityName(@Param("cityName") String cityName);
}
