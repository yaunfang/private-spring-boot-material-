

# [Spring Boot 之 HelloWorld详解](https://www.bysocket.com/technique/1124.html)

-  发表于：[2016年4月25日](https://www.bysocket.com/technique/1124.html)
-  分类：[Spring](https://www.bysocket.com/category/technique/spring), [Spring Boot](https://www.bysocket.com/category/springboot), [技术](https://www.bysocket.com/category/technique)
-  标签：[Spring](https://www.bysocket.com/tag/spring), [Spring Boot](https://www.bysocket.com/tag/spring-boot)
- 

**号外：为读者持续整理了几份最新教程，覆盖了 Spring Boot、Spring Cloud、微服务架构等PDF。
获取方式：关注右侧公众号"泥瓦匠BYSocket"，来领取吧！**

------

**摘要: 原创出处 https://www.bysocket.com 「公众号：泥瓦匠BYSocket 」欢迎关注和转载，保留摘要，谢谢！**

摘要: 原创出处:www.bysocket.com 泥瓦匠BYSocket 希望转载，保留摘要，谢谢！

“以前是人放狗看家，现在是狗牵着人散步” — 随笔

Spring Boot 系列文章：《[Spring Boot 那些事](http://www.bysocket.com/?page_id=1639)》



# 一、Spring Boot 自述

世界上最好的文档来源自官方的《[Spring Boot Reference Guide](https://g.halouworld.com:5555/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&ved=0ahUKEwirptX0jqrMAhVFmZQKHTBIDIcQFggqMAE&url=http%3a%2f%2fdocs.spring.io%2fspring-boot%2fdocs%2fcurrent%2freference%2fhtmlsingle%2f&usg=AFQjCNF-iUAjNLcDaGoKyG7R7g50nY1zfA)》，是这样介绍的：

> Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can “just run”…Most Spring Boot applications need very little Spring configuration.

Spring Boot(英文中是“引导”的意思)，是用来简化Spring应用的搭建到开发的过程。应用开箱即用，只要通过 “just run”（可能是 java -jar 或 tomcat 或 maven插件run 或 shell脚本），就可以启动项目。二者，Spring Boot 只要很少的Spring配置文件（例如那些xml，property）。

因为“习惯优先于配置”的原则，使得Spring Boot在快速开发应用和微服务架构实践中得到广泛应用。

 

Javaer装好JDK环境和Maven工具就可以开始学习Boot了~

# 二、HelloWorld实战详解

首先得有个maven基础项目，可以直接使用Maven骨架工程生成Maven骨架Web项目，即mvn archetype:generate命令：

```
mvn archetype:generate -DgroupId=springboot -DartifactId=springboot-helloworld -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

### 2.1  pom.xml配置

代码如下：

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>springboot</groupId>
    <artifactId>springboot-helloworld</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>springboot-helloworld :: HelloWorld Demo</name>

    <!-- Spring Boot 启动父依赖 -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.3.3.RELEASE</version>
    </parent>

    <dependencies>
        <!-- Spring Boot web依赖 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Junit -->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>
    </dependencies>
</project>
```

只要加入一个 Spring Boot 启动父依赖即可。

 

### 2.2 Controller层

HelloWorldController的代码如下：

```
/**
 * Spring Boot HelloWorld案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }
}
```

@RestController和@RequestMapping注解是来自SpringMVC的注解，它们不是SpringBoot的特定部分。

1. @RestController：提供实现了REST API，可以服务JSON,XML或者其他。这里是以String的形式渲染出结果。

   

2. @RequestMapping：提供路由信息，”/“路径的HTTP Request都会被映射到sayHello方法进行处理。

具体参考，世界上最好的文档来源自官方的《[Spring Framework Document](http://docs.spring.io/spring/docs/current/spring-framework-reference/htmlsingle/)》

### 2.3 启动应用类

和第一段描述一样，开箱即用。如下面Application类：

```
/**
 * Spring Boot应用启动类
 *
 * Created by bysocket on 16/4/26.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
```

1. @SpringBootApplication：Spring Boot 应用的标识

   

2. Application很简单，一个main函数作为主入口。SpringApplication引导应用，并将Application本身作为参数传递给run方法。具体run方法会启动嵌入式的Tomcat并初始化Spring环境及其各Spring组件。

 

### 2.4 Controller层测试类

一个好的程序，不能缺少好的UT。针对HelloWorldController的UT如下：

```
/**
 * Spring Boot HelloWorldController 测试 - {@link HelloWorldController}
 *
 * Created by bysocket on 16/4/26.
 */
public class HelloWorldControllerTest {

    @Test
    public void testSayHello() {
        assertEquals("Hello,World!",new HelloWorldController().sayHello());
    }
}
```

 

# 三、运行

Just Run的宗旨，运行很简单，直接右键Run运行Application类。同样你也可以Debug Run。可以在控制台中看到：

```
Tomcat started on port(s): 8080 (http)
Started Application in 5.986 seconds (JVM running for 7.398)
```

然后访问 http://localhost:8080/ ,即可在页面中看到Spring Boot对你 say hello：

```
Hello,World！
```

 

# 四、小结

1. Spring Boot pom配置

   

2. Spring Boot 启动及原理

3. 对应代码分享在 [Github](https://github.com/JeffLi1993/springdream/tree/master/springboot) 主页

------

**如以上文章或链接对你有帮助的话，别忘了在文章结尾处评论哈~ 你也可以点击页面右边“分享”悬浮按钮哦，让更多的人阅读这篇文章。**

## 代码示例

本文示例读者可以通过查看下面仓库的中代码 ：

- [GitHub（springboot-learning-example）](https://github.com/JeffLi1993/springboot-learning-example)
- [Gitee（springboot-learning-example）](https://gitee.com/jeff1993/springboot-learning-example)

如果您对这些感兴趣，欢迎 star、follow、收藏、转发给予支持！

## 以下专题教程也许您会有兴趣

- [《Spring Boot 2.x 系列教程》](https://www.bysocket.com/springboot)
- [《Java 核心系列教程》](https://www.bysocket.com/archives/2100)

![img](http://www.bysocket.com/wp-content/uploads/2017/01/qrcode_for_gh_cd421e7eb7d6_430.jpg)
**（关注微信公众号，领取 Java 精选干货学习资料）**
**（添加我微信：bysocket01。加入纯技术交流群，成长技术）**