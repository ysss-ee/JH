package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hp
 * @description 针对表【user】的数据库操作Mapper
 * @createDate 2025-08-27 21:45:14
 * @Entity com.example.demo.entity.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




