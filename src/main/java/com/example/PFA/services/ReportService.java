package com.example.PFA.services;

import com.example.PFA.entities.Officer;
import com.example.PFA.entities.Report;
import com.example.PFA.entities.User;
import com.example.PFA.repositories.OfficerRepository;
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

    @Autowired
    private OfficerRepository officerRepository;

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

    public Report linkReportToOfficer(String reportId, String officerId) {
        Report report = reportRepository.findById(reportId).orElseThrow(() -> new RuntimeException("Report not found"));
        Officer officer = officerRepository.findById(officerId).orElseThrow(() -> new RuntimeException("Officer not found"));

        report.setOfficer(officer);
        return reportRepository.save(report);
    }
}
