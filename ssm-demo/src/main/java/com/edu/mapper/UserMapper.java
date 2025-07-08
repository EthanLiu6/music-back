package com.edu.mapper;

import com.edu.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> findAll();
}
