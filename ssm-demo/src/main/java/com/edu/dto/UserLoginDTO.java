package com.edu.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @ProjectName: music-project
 * @Titile: UserLoginDTO
 * @Author: Administrator
 * @Description: 用户登录DTO
 */
@Data
public class UserLoginDTO {
    @NotBlank(message = "登录的用户名或手机号或邮箱不能为空")
    private String account;
    @NotBlank(message = "登录密码不能为空")
    @Length(min = 6,max = 12,message = "密码长度为{min}-｛max｝位")
    private String password;
}
