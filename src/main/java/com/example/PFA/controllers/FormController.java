package com.example.PFA.controllers;

import com.example.PFA.entities.Demande;
import com.example.PFA.entities.User;
import com.example.PFA.repositories.DemandeRepository;
import com.example.PFA.repositories.UserRepository;
import com.example.PFA.states.Pending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/form")
public class FormController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @PostMapping("/submit")
    public Demande submitForm(@RequestBody FormDataDTO formData) {
        // Create and save the User
        User user = new User();
        user.setName(formData.getNom());
        user.setSurname(formData.getPrenom());
        user.setPhone(formData.getTelephone());
        user.setCin(formData.getCnie());
        user = userRepository.save(user);

        // Create and save the Demande
        Demande demande = new Demande(new Pending());
        demande.setUser(user);
        demande = demandeRepository.save(demande);

        // Add the demande to the user's list of demandes and save the user
        user.getDemandes().add(demande);
        userRepository.save(user);

        return demande;
    }
}
