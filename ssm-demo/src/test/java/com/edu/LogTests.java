package com.edu;

import com.edu.mapper.LogMapper;
import com.edu.pojo.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//单元测试
@SpringBootTest
@Slf4j //lombok的日志注解
class LogTests {

    @Autowired
    private LogMapper logMapper;

    @Test
    void testFindLogs() {
        List<Log> logs = logMapper.findLogs();
        log.info("日志数量: {}", logs.size());
        for (Log logEntry : logs) {
            log.info("日志: {}", logEntry);
        }
        // 简单断言
        assert logs != null;
    }
}