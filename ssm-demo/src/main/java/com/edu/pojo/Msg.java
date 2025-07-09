package com.edu.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Msg {
    private Integer id;         // 消息主键
    private String title;       // 消息主题
    private Integer userId;     // 接收消息的用户编号
    private String msg;         // 消息内容
    private Date createTime;    // 创建时间
    private Integer isread;     // 是否已读
}