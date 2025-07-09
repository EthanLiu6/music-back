package com.edu;

import com.edu.mapper.MusicMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

//单元测试
@SpringBootTest
@Slf4j //lombok的日志注解
class MusicTests {
    @Autowired
    private MusicMapper musicMapper;

    @Test
    void testCountMusic() {
        int count = musicMapper.countMusic();
        assertTrue(count >= 0);
    }

}
