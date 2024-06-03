package com.example.PFA.controllers;

import com.example.PFA.entities.Officer;
import com.example.PFA.entities.User;
import com.example.PFA.services.OfficerService;
import com.example.PFA.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/officers")
public class OfficerController {

    @Autowired
    private OfficerService officerService;

    @GetMapping
    public List<Officer> getAllOfficers() {
        return officerService.getAllOfficers();
    }

    @GetMapping("/{id}")
    public Optional<Officer> getOfficerById(@PathVariable String id) {
        return officerService.getOfficerById(id);
    }

    @PostMapping
    public Officer createOfficer(@RequestBody Officer officer) {
        return officerService.createOfficer(officer);
    }

    @DeleteMapping("/{id}")
    public void deleteOfficer(@PathVariable String id) {
        officerService.deleteOfficer(id);
    }
}
