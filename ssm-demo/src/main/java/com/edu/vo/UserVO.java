package com.edu.vo;

import lombok.Data;

/**
 * @ProjectName: music-project
 * @Titile: UserVO
 * @Author: Administrator
 * @Description: 用户登录成功后的用户VO
 */
@Data
public class UserVO {
    private String token;
    private String username;
    private String imageUrl;
}
