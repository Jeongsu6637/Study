package com.learn.service;

import com.learn.entity.User;
import com.learn.mapper.UserMapper;
import com.learn.request.loginRequest;
import com.learn.request.signupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserMapper userMapper;
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public signupRequest signUp(signupRequest req){
        return userMapper.signUp(req);
    }
    public User login(loginRequest req){
        return userMapper.login(req);
    }

}
