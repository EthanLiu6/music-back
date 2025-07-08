package com.edu.service;

import com.edu.dto.UserLoginDTO;
import com.edu.pojo.User;
import com.edu.vo.UserVO;

import java.util.List;

public interface UserService {
    List<User> findAll();

    /**
     * 登录业务方法
     * @param userLoginDTO 登录数据
     * @return 登录成功后的数据
     */
    UserVO login(UserLoginDTO userLoginDTO);
}
