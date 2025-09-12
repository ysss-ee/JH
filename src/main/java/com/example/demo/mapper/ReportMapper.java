package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Report;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hp
 * @description 针对表【report】的数据库操作Mapper
 * @createDate 2025-08-27 21:45:02
 * @Entity com.example.demo.entity.Report
 */
@Mapper
public interface ReportMapper extends BaseMapper<Report> {

}




