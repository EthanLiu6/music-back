package com.edu.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Log {
    private String userName;    // 操作人姓名
    private String doSome;      // 具体操作
    private String musicName;   // 歌曲名称
    private Date createDate;    // 创建时间
}