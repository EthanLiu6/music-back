package com.edu.commons;

/**
 * @ProjectName: myApp
 * @Titile: GlobalExceptionHandler
 * @Author: Administrator
 * @Description: 全局异常处理
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.NestedRuntimeException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;

/**
 * @Description: 全局异常类
 */
@RestControllerAdvice //对所有的控制器进行增强 AOP
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 处理业务异常
     * @param e
     * @return
     */
    @ExceptionHandler // 处理异常，只要出现了ServiceException，都会直接执行这个方法
    public R<Void> serviceExceptionHandle(ServiceException e) {
        return R.fail(e);
    }

    /**
     * 请求异常的处理（参数错误，请求方式）
     * @param e
     * @return
     */
    @ExceptionHandler  //只要报NestedRuntimeException异常，就会执行这个方法
    public R<Void> badRequestExceptionHandle(NestedRuntimeException e) {
        log.debug("{}",e);
        //创建业务异常
        ServiceException ex = new ServiceException(ServiceCode.ERROR_BAD_REQUEST,"请求的数据或者类型错误");
        return R.fail(ex);
    }

    /**
     * 数据校验时发生异常的处理
     * @param e 数据绑定异常
     * @return
     */
    @ExceptionHandler
    public R<Void> validateExceptionHandle(BindException e) {
        //创建业务异常
        ServiceException ex = new ServiceException(ServiceCode.ERROR_BAD_REQUEST,e.getFieldError().getDefaultMessage());
        return R.fail(ex);
    }

    /**
     * 请求servlet的异常 404
     * @param e
     * @return
     */
    @ExceptionHandler
    public R<Void> servletExceptionHandle(ServletException e){
        if(e instanceof NoHandlerFoundException){
            return R.fail(new ServiceException(ServiceCode.ERROR_BAD_REQUEST,"请求路径不存在"));
        }
        return R.fail(new ServiceException(ServiceCode.ERROR_BAD_REQUEST,e.getMessage()));
    }

    /**
     * 未知错误
     * 在测试中出现此错误，一定要处理
     * @param e
     * @return
     */
    @ExceptionHandler
    public R<Void> throwableHandle(Throwable e){
        e.printStackTrace();//这种打印堆栈的错误信息，是不能使用的，因为它是堵塞式，上线后，一定要记得删除或者注释掉此代码
        return R.fail(new ServiceException(ServiceCode.ERROR_UN_KNOW,"服务器端错误，请联系管理员"));
    }

}

