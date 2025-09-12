package com.example.demo.service;

import com.example.demo.dto.LogResponse;
import com.example.demo.dto.RegisterResponse;
import org.springframework.stereotype.Service;

/**
 * @author hp
 * @description 针对表【user】的数据库操作Service
 * @createDate 2025-08-21 23:08:10
 */
@Service
public interface UserService {


    LogResponse login(String username, String password);

    RegisterResponse register(String username, String password, Integer userType);


}
