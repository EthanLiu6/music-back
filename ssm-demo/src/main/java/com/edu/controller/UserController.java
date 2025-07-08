package com.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: music-project
 * @Titile: UserController
 * @Author: Administrator
 * @Description: 演示控制器
 */
@RestController //返回数据
@RequestMapping("/api/user") //以及目录
public class UserController {

    @GetMapping("hello")
    public String hello(){
        return "hello,SpringBoot";
    }
}
