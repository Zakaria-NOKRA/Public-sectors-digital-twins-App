package com.example.PFA.controllers;

import com.example.PFA.entities.Report;
import com.example.PFA.entities.User;
import com.example.PFA.services.ReportService;
import com.example.PFA.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public Optional<Report> getReportById(@PathVariable String id) {
        return reportService.getReportById(id);
    }

    @PostMapping
    public Report createReport(@RequestBody Report report) {
        return reportService.createReport(report);
    }

    @GetMapping("/{reportId}/users")
    public List<User> getUsersByReport(@PathVariable String reportId) {
        return userService.getUsersByReport(reportId);
    }

    @DeleteMapping("/{id}")
    public void deleteReport(@PathVariable String id) {
        reportService.deleteReport(id);
    }

    @PostMapping("/{reportId}/officers/{officerId}")
    public Report linkReportToOfficer(@PathVariable String reportId, @PathVariable String officerId) {
        return reportService.linkReportToOfficer(reportId, officerId);
    }

}
