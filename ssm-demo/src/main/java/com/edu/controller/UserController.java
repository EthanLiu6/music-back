package com.edu.controller;

import com.edu.commons.R;
import com.edu.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @ProjectName: music-project
 * @Titile: UserController
 * @Author: Administrator
 * @Description: 演示控制器
 */
@Slf4j
@RestController //返回数据
@RequestMapping("/api/user") //以及目录
public class UserController {

    @GetMapping("hello")
    public String hello(){
        return "hello,SpringBoot";
    }
}
