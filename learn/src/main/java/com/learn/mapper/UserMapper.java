package com.learn.mapper;

import com.learn.entity.User;
import com.learn.request.loginRequest;
import com.learn.request.signupRequest;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    signupRequest signUp(signupRequest req);
    User login(loginRequest req);

}
