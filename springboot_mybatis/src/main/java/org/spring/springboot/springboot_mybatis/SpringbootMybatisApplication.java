package org.spring.springboot.springboot_mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 应用程序启动类
 * 
 * Created by QQ.y 20/5/27
 */
// SpringBoot 应用标志
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("org.spring.springboot.springboot_mybatis.dao")
public class SpringbootMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }

}
