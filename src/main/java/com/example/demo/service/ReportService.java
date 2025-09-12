package com.example.demo.service;

import com.example.demo.entity.Report;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportService {


    void deleteReport(Integer userId, Integer reportId, Integer approval);

    List<Report> getReportPosts(Integer userId);

    List<Report> checkReport(Integer userId);
}
