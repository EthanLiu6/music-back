package com.edu.commons;
import lombok.Getter;

/**
 * @Titile: ServiceCode
 * @Author: Administrator
 * @Description: 业务码
 */
public enum ServiceCode {
    /*执行成功*/
    OK(20000),
    /*执行失败*/
    FAIL(30000),
    /*参数错误*/
    ERROR_BAD_REQUEST(40000),
    /*用户未登录*/
    ERROR_UN_LOGIN(50000),
    /*用户未授权*/
    ERROR_UN_AUTHORIZED(60000),
    /*token错误*/
    ERROR_TOKEN(60001),
    /*新增失败*/
    ERROR_INSERT(50001),
    /*删除失败*/
    ERROR_DELETE(50002),
    /*修改失败*/
    ERROR_UPDATE(50003),
    /*查询失败*/
    ERROR_DATA_NOT_FOUND(50004),
    /*文件上传错误*/
    ERROR_FILE_UPLOAD(50005),
    // ....
    /*未知错误*/
    ERROR_UN_KNOW(90000);

    //公开外部可以访问的getter
    @Getter
    private int code;

    /*public int getCode() {
        return code;
    }*/
    //alt+ insert
    ServiceCode(int code) {
        this.code = code;
    }
}
