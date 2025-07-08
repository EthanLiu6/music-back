package com.edu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;

/**
 * @ProjectName: music-project
 * @Titile: MyBatisConfig
 * @Author: Administrator
 * @Description: TODO
 */
@SpringBootConfiguration
@MapperScan("com.edu.mapper") //指定扫描的包位置
public class MyBatisConfig {
}
