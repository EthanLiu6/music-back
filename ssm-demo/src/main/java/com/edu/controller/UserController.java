package com.edu.controller;

import com.edu.commons.R;
import com.edu.dto.UserLoginDTO;
import com.edu.pojo.User;
import com.edu.service.UserService;
import com.edu.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
//@CrossOrigin //跨域注解
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("hello")
    public String hello(){
        return "hello,SpringBoot";
    }

    @PostMapping("login")
    public R<UserVO> login(@Validated UserLoginDTO userLoginDTO){
        log.info("有用户登录:{}",userLoginDTO);
        UserVO userVO = userService.login(userLoginDTO);
        return R.ok("登录成功",userVO);
    }
}
