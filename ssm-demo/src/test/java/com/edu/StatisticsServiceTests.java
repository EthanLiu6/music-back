package com.edu;

import com.edu.dto.StatisticsDTO;
import com.edu.service.StatisticsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatisticsServiceTests {

    @Autowired
    private StatisticsService statisticsService;

    @Test
    void testGetStatistics() {
        StatisticsDTO dto = statisticsService.getStatistics();
        assertNotNull(dto);
        assertTrue(dto.getUserCount() >= 0);
        assertTrue(dto.getSingerCount() >= 0);
        assertTrue(dto.getMusicCount() >= 0);
    }
}