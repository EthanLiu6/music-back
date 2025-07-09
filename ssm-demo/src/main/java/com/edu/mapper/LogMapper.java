package com.edu.mapper;

import com.edu.pojo.Log;

import java.util.List;

public interface LogMapper {

    List<Log> findLogs();  // 查询所有的日志（用户、操作、时间）
    // TODO: 分页查询处理
}