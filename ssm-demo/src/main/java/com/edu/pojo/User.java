package com.edu.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ProjectName: music-project
 * @Titile: User
 * @Author: Administrator
 * @Description: 实体类
 */
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //邮箱（不重）
    private String email;
    //手机号（不重复）
    private String  phone;
    //规则（角色 0为管理员 1为歌手 2为普通用户）
    private Integer role;
    //是否激活（针对歌手）
    private Integer activation;
   // date
    private Date createTime;
    //头像
    private String imageUrl;
     //简介
    private String  about;

}
