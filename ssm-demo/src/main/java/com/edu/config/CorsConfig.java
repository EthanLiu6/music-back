package com.edu.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: music-project
 * @Titile: CorsConfig
 * @Author: Administrator
 * @Description: 跨域设置
 */
@SpringBootConfiguration
public class CorsConfig  implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //允许所有
                .allowedMethods("*")//允许所有方法
                .allowedHeaders("*")//允许所有的头
                .allowedOriginPatterns("*")
                .allowCredentials(true) //允许带上身份
                .maxAge(3600);//缓存时间
    }
}
