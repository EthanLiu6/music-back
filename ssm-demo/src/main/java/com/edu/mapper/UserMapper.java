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
}
