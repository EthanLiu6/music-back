package com.edu.dto;

import com.edu.pojo.Log;
import lombok.Data;

import java.util.List;

@Data
public class StatisticsDTO {
    private int userCount;
    private int singerCount;
    private int musicCount;
    private List<Log> logList;
}