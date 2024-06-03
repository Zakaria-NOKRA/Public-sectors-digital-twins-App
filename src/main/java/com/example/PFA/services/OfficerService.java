package com.example.PFA.services;

import com.example.PFA.entities.Officer;
import com.example.PFA.repositories.OfficerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OfficerService {

    @Autowired
    private OfficerRepository officerRepository;

    public List<Officer> getAllOfficers() {
        return officerRepository.findAll();
    }

    public Optional<Officer> getOfficerById(String id) {
        return officerRepository.findById(id);
    }

    public Officer createOfficer(Officer officer) {
        return officerRepository.save(officer);
    }

    public void deleteOfficer(String id) {
        officerRepository.deleteById(id);
    }
}
