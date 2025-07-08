package com.edu.interceptor;

import com.edu.commons.Constants;
import com.edu.commons.JWTUtil;
import com.edu.commons.ServiceCode;
import com.edu.commons.ServiceException;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ProjectName: music-project
 * @Titile: AuthInterceptor
 * @Author: Administrator
 * @Description: 拦截器
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从请求头中获取用户的身份
        String token = request.getHeader(Constants.TOKEN_KEY);
        //判断token是否存在
        if(!StringUtils.hasLength(token)){
           throw new ServiceException(ServiceCode.ERROR_TOKEN,"token不能为空");
        }
        //token存在
        //校验token
        JWTUtil.validateToken(token);
        //token是ok的，
        // 将token进行解析
        request.setAttribute("id",JWTUtil.getUserIdByToken(token));
        request.setAttribute("username",JWTUtil.getUsernameByToken(token));
        return true; //不拦截
    }
}
