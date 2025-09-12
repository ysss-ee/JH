package com.example.demo.controller;


import com.example.demo.dto.DeleteReportRequest;
import com.example.demo.dto.Result;
import com.example.demo.entity.Report;
import com.example.demo.service.ReportService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class ReportController {
    @Resource
    private ReportService reportService;


    @DeleteMapping("/admin/report")
    public Result<String> deleteReport(@RequestBody DeleteReportRequest post) {
        reportService.deleteReport(post.getUserId(), post.getReportId(), post.getApproval());
        return Result.success();

    }

    @GetMapping("/admin/report")
    public Result<List<Report>> getReportPosts(@RequestParam Integer userId) {
        List<Report> reports;
        reports = reportService.getReportPosts(userId);
        return Result.success(reports);

    }

    @GetMapping("/student/report_post")
    public Result<List<Report>> checkReport(@RequestParam Integer userId) {
        List<Report> reports = reportService.checkReport(userId);
        return Result.success(reports);


    }
}
