package com.edu;

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
class SsmDemoApplicationTests {
    @Autowired
    private UserService userService;
    @Test
    void findAll() {
        List<User> users = userService.findAll();
        log.info("{}",users);
    }

}
