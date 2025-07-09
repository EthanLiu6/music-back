package com.edu.controller;

import com.edu.dto.StatisticsDTO;
import com.edu.commons.R;
import com.edu.service.StatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 返回数据
@RequestMapping("/api/home") //以及目录
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("statistics")
    public R<StatisticsDTO> getStatistics() {
        StatisticsDTO dto = statisticsService.getStatistics();
        return R.ok("查询成功", dto);
    }
}