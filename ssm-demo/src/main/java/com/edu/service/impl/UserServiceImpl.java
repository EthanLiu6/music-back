package com.edu.service.impl;

import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import com.edu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: music-project
 * @Titile: UserServiceImpl
 * @Author: Administrator
 * @Description: 用户业务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll() {
        List<User> users = userMapper.findAll();
        if(users!=null&& !users.isEmpty()){
            return users;
        }
        throw new RuntimeException("没有数据");
    }
}
