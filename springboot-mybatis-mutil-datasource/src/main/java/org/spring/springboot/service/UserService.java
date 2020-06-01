package org.spring.springboot.service;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.entity.User;

/**
 * 用户 业务逻辑层 接口类
 *
 * Created By QQ.y 2020/6/1
 */
public interface UserService {

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName 用户名
     * @return User 用户对象
     */
    User findByName(@Param("userName")String userName);
}
