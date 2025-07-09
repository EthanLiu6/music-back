package com.edu.service.impl;

import com.edu.dto.StatisticsDTO;
import com.edu.mapper.UserMapper;
import com.edu.mapper.MusicMapper;
import com.edu.mapper.LogMapper;
import com.edu.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MusicMapper musicMapper;
    @Autowired
    private LogMapper logMapper;

    @Override
    public StatisticsDTO getStatistics() {
        StatisticsDTO dto = new StatisticsDTO();
        dto.setUserCount(userMapper.countUser());
        dto.setSingerCount(userMapper.countSinger());
        dto.setMusicCount(musicMapper.countMusic());
        dto.setLogList(logMapper.findLogs());
        return dto;
    }
}