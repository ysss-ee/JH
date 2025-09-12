package com.example.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.constant.ExceptionEnum;
import com.example.demo.dto.LogResponse;
import com.example.demo.dto.RegisterResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.ApiException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author hp
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2025-08-21 23:08:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    public LogResponse login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null || !password.equals(user.getPassword())) {
            throw new ApiException(ExceptionEnum.RESOURCE_NOT_FOUND);
        }
        return LogResponse.builder()
                .userId(user.getId())
                .userType(user.getUserType())
                .build();
    }

    @Override
    public RegisterResponse register(String username, String password, Integer userType) {
        if (!(userType == 1) && !(userType == 2)) {
            throw new ApiException(ExceptionEnum.INVALID_PARAMETER);
        }
        User user = User.builder()
                .username(username)
                .password(password)
                .userType(userType)
                .build();
        userMapper.insert(user);

        return RegisterResponse.builder()
                .userId(user.getId())
                .build();


    }
}



