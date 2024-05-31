package com.example.PFA.services;

import com.example.PFA.entities.Report;
import com.example.PFA.entities.User;
import com.example.PFA.repositories.ReportRepository;
import com.example.PFA.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Optional<Report> getReportById(String id) {
        return reportRepository.findById(id);
    }

    public Report createReport(Report report) {
        return reportRepository.save(report);
    }

    public void deleteReport(String id) {
        reportRepository.deleteById(id);
    }
}
