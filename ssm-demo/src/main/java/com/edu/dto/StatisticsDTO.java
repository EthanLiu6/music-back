package com.edu.dto;

// import com.edu.pojo.Log;
import lombok.Data;

// import java.util.List;
/**
 * * 首页看板信息DTO
 * 用于返回给前端的首页看板信息
 * 包括用户数量、歌手数量、音乐数量、管理员头像
 */
@Data
public class StatisticsDTO {
    private int userCount;
    private int singerCount;
    private int musicCount;
    // private List<Log> logList; // 分页查询其相关信息单独拎出来
    private String adminImageUrl; //左上角管理员头像
}