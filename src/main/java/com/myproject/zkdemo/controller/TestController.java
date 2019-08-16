package com.myproject.zkdemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author wenhuigong
 * @Date 2019/7/27 14:00
 * @Description
 **/
@RestController
public class TestController {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${server.port}")
    private String port;

    @GetMapping("/url")
    public String getUrl(){
        return url + "\n" +port;
    }
}
