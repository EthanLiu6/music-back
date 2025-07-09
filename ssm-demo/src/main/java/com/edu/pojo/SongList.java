package com.edu.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class SongList {
    private Integer id;         // 歌单编号
    private String name;        // 歌单名称
    private Integer user;       // 歌单所属用户id
    private String image;       // 歌单图片
    private String message;     // 歌单介绍
    private Date createDate;    // 创建时间
    private String tags;        // 歌单标签
}