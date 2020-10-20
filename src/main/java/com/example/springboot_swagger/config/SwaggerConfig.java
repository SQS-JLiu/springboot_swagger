package com.example.springboot_swagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2  访问页面： http://localhost:8080/swagger-ui.html
public class SwaggerConfig {

    //配置了Swagger2的Docket的bean实例
    @Bean
    public Docket docket(){
        //return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
        // RequestHandlerSelectors 选择要扫描接口的方式
        // RequestHandlerSelectors.any() 扫描全部
        // RequestHandlerSelectors.none()  都不扫描
        // RequestHandlerSelectors.withClassAnnotation(Controller.class)  扫描类上的注解
        // RequestHandlerSelectors.withMethodAnnotation(GetMapping.class) 扫描方法上的注解
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .enable(true)   // 默认值为true, false则关闭Swagger,可读取配置文件的环境状态(dev/produce),切换是否开启swagger
                .select().apis(RequestHandlerSelectors.basePackage("com.example.springboot_swagger.controller"))
                //.paths(PathSelectors.ant("/test/**"))  //过滤路径,扫描/test/**下的请求接口
                .build();
    }


    //配置Swagger的信息：apiInfo   修改Swagger的主页面展示信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact DEFAULT_CONTACT = new Contact("测试者", "https://www.baidu.com/", "xxx@qq.com");
        return new ApiInfo("我的 Api Documentation",  //默认值 Api Documentation
                "我的 Api Documentation",        //默认值 Api Documentation
                "1.0",
                "https://www.baidu.com/",                 //默认值  urn:tos
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

    // 配置分组，每个人可只查看自己的接口， 即多Docket实例
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("2");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("3");
    }
}
