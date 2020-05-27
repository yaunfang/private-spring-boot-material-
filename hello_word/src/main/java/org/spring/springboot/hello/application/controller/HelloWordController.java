package org.spring.springboot.hello.application.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld案例
 *
 *Created by QQ.y on 20/5/27
 */
@RestController
public class HelloWordController {

    @RequestMapping("/")
    public String sayHelloWord(){
        return "hello,Word!";
    }
}
