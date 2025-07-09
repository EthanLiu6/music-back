package com.edu;

import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import com.edu.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//单元测试
@SpringBootTest
@Slf4j //lombok的日志注解
class UserTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void login() {
        User user = userMapper.findByAccount("2841958846@qq.com");
        log.info("{}",user);
    }

}
