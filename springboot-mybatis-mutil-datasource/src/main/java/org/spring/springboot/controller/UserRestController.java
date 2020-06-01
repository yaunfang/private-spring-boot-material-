package org.spring.springboot.controller;

import org.spring.springboot.entity.User;
import org.spring.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户 控制层
 *
 * Created By QQ.y 2020/6/1
 */
@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

    /**
     * 根据用户名获取用户信息，包括从库的地址信息
     *
     * @param userName 用户名
     * @return User 用户对象，包含从库中的地址信息
     */
    @RequestMapping(value = "api/user",method = RequestMethod.GET)
    public User findUserByUserName(@RequestParam(value = "userName",required = true)String userName){
        return userService.findByName(userName);
    }
}
