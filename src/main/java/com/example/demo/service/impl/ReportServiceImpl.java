package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.constant.ExceptionEnum;
import com.example.demo.entity.Post;
import com.example.demo.entity.Report;
import com.example.demo.entity.User;
import com.example.demo.exception.ApiException;
import com.example.demo.mapper.PostMapper;
import com.example.demo.mapper.ReportMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.ReportService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hp
 * @description 针对表【report】的数据库操作Service实现
 * @createDate 2025-08-21 14:16:31
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ReportServiceImpl implements ReportService {
    @Resource
    private PostMapper postMapper;
    @Resource
    private ReportMapper reportMapper;
    @Resource
    private UserMapper userMapper;

    // 检查管理员权限
    private void checkAdminPermission(Integer userId) {
        User user = userMapper.selectById(userId);
        if (user == null || user.getUserType() != 2) {
            throw new ApiException(ExceptionEnum.PERMISSION_NOT_ALLOWED);
        }
    }


    @Override
    public void deleteReport(Integer userId, Integer reportId, Integer approval) {
        checkAdminPermission(userId);
        Report report = reportMapper.selectById(reportId);
        if (report == null) {
            throw new ApiException(ExceptionEnum.RESOURCE_NOT_FOUND);
        }
        if (!(approval == 1) && !(approval == 2)) {
            throw new ApiException(ExceptionEnum.INVALID_PARAMETER);
        }
        if (approval == 1) {
            Post post = postMapper.selectById(report.getPostId());
            postMapper.deleteById(post);
        }
        report.setApproval(approval);
        reportMapper.updateById(report);


    }

    @Override
    public List<Report> getReportPosts(Integer userId) {
        checkAdminPermission(userId);
        LambdaQueryWrapper<Report> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Report::getApproval, 0);
        return reportMapper.selectList(queryWrapper);
    }

    @Override
    public List<Report> checkReport(Integer userId) {
        List<Report> reports = reportMapper.selectList(new LambdaQueryWrapper<Report>().eq(Report::getUserId, userId));
        if (reports.isEmpty() && userMapper.selectById(userId) == null) {
            throw new ApiException(ExceptionEnum.RESOURCE_NOT_FOUND);
        }
        return reports;

    }


}
