package com.edu.commons;

import lombok.Data;

/**
 * @ProjectName: music-project
 * @Titile: R
 * @Author: Administrator
 * @Description: 返回的数据结构
 */
@Data //lombok的注解
public class R<T> {
    //业务码
    private Integer code;
    //消息
    private String message;
    //数据
    private T data;

    /**
     * 操作成功，不携带数据
     * @param message 操作的结果信息
     * @return
     */
    public static R<Void> ok(String message){
        R<Void> r = new R<>();
        r.setCode(20000);
        r.setMessage(message);
        return r;
    }

    /**
     * 操作成功，携带数据
     * @param message 操作的结果信息
     * @param data 携带的数据
     * @return 返回数据
     */
    public static <T> R<T>  ok(String message, T data){
        R<T> r = new R<>();
        r.setCode(20000);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

    /**
     * 操作失败
     * @param e 业务异常
     * @return
     */
    public static R<Void> fail(ServiceException e){
        R<Void> r = new R<>();
        r.setCode(e.getServiceCode().getCode());
        r.setMessage(e.getMessage());
        return r;
    }
}
