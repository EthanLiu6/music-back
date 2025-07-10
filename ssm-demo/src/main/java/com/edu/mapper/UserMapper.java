package com.edu.mapper;

import com.edu.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAll();

    /**
     * 根据账户查询用户
     * @param account  账户
     * @return 用户对象
     */
    User findByAccount(String account);

    Integer countUser();  // 查询用户数量

    Integer countSinger();  // 查询歌手数量

    String findAdminImageUrl();  // 查询管理员头像（用于和首页看板信息整合接口发送给前端）
}
