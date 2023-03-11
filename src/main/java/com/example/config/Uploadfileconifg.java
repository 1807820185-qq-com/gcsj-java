package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Uploadfileconifg implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //获取项目在本机上的路径   动态获取
        String ValuePath="home/zyk/picture_gcsj/";
//        String ValuePath = System.getProperty("user.dir");
        //图片存储的真实路径
        String path=ValuePath+"\\src\\main\\resources\\image";
        //  将路由/image/** 映射到真实路径
        registry.addResourceHandler("/image/**").addResourceLocations("file:///"+ValuePath+"img/");
        registry.addResourceHandler("/coverimage/**").addResourceLocations("file:///"+ValuePath+"coverimg/");
        registry.addResourceHandler("/file/**").addResourceLocations("file:///"+ValuePath+"file/");
    }
}


