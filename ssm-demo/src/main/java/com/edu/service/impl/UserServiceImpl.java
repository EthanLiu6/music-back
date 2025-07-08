package com.edu.service.impl;

import com.edu.commons.JWTUtil;
import com.edu.commons.MD5Utils;
import com.edu.commons.ServiceCode;
import com.edu.commons.ServiceException;
import com.edu.dto.UserLoginDTO;
import com.edu.mapper.UserMapper;
import com.edu.pojo.User;
import com.edu.service.UserService;
import com.edu.vo.UserVO;
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

    @Override
    public UserVO login(UserLoginDTO userLoginDTO) {
        // 如果校验框架不能校验的数据，我们可以在这里校验
        User user = userMapper.findByAccount(userLoginDTO.getAccount());
        if(user==null){
            throw new ServiceException(ServiceCode.ERROR_DATA_NOT_FOUND,"用户未注册");
        }
        //将登录密码加密
        String pwd = MD5Utils.stringToMD5(userLoginDTO.getPassword());
        //跟数据库中的密码进行比对密码
        if(!pwd.equals(user.getPassword())){
            throw new ServiceException(ServiceCode.ERROR_DATA_NOT_FOUND,"密码错误");
        }
        UserVO userVO = new UserVO();
        userVO.setUsername(user.getUsername());
        userVO.setImageUrl(user.getImageUrl());
        //生成token
        String token = JWTUtil.generateToken(user.getId(), user.getUsername());
        userVO.setToken(token);
        return userVO;
    }
}
