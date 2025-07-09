package com.edu.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class Music {
    private Integer musicId;      // 歌曲编号
    private Integer fromSinger;   // 歌手用户id
    private String musicName;     // 歌曲名
    private String musicUrl;      // 歌曲文件地址
    private Integer activation;   // 激活状态
    private Integer listenNumb;   // 播放量
    private String imageUrl;      // 歌曲图片地址
    private Integer timelength;   // 歌曲时长（这个在数据库中没用是timelength，所以只好这样映射）
    private Date createTime;      // 创建时间
    private String tags;          // 标签
    private String lyric;         // 歌词
}