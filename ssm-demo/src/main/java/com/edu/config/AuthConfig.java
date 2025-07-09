package com.edu.config;

import com.edu.interceptor.AuthInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ProjectName: music-project
 * @Titile: AuthConfig
 * @Author: Administrator
 * @Description: 注册token拦截器
 */
@SpringBootConfiguration //语义化
public class AuthConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**") //拦截所有
                .excludePathPatterns("/api/user/login", "/api/home/statistics");//放行
                //todo 放行注册
    }
}
