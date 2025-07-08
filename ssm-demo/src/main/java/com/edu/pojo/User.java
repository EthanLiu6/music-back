package com.edu.pojo;

import lombok.Data;

/**
 * @ProjectName: music-project
 * @Titile: User
 * @Author: Administrator
 * @Description: 实体类
 */
@Data
public class User {
    private Integer id;
    //用户名
    private String username;
    //密码
    private String password;
    //邮箱（不重）
    private String email;
    //手机号（不重复）	varchar	phone
    //规则（角色 0为管理员 1为歌手 2为普通用户）	int	role
    //是否激活（针对歌手）	int	activation
    //date	create_time
    //varchar	image_url
    // varchar	about

}
