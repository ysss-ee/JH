package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private JwtUtil jwtUtil;

    @PostMapping("/reg")
    public Result<RegisterResponse> register(@RequestBody RegisterRequest registerRequest) {
        RegisterResponse result = userService.register(registerRequest.getUsername(), registerRequest.getPassword(), registerRequest.getUserType());
        return Result.success(result);

    }

    @PostMapping("/login")
    public Result<LogResponse> login(@RequestBody LoginRequest login) {
        LogResponse logResponse = userService.login(login.getUsername(), login.getPassword());
        String token = jwtUtil.generateToken(login.getUsername());

        // 构建登录响应，包含用户信息和JWT令牌
        LogResponse response = LogResponse.builder()
                .userId(logResponse.getUserId())
                .userType(logResponse.getUserType())
                .token(token)
                .build();
        return Result.success(response);

    }


}
