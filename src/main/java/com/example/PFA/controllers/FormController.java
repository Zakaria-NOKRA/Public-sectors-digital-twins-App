package com.example.PFA.controllers;

import com.example.PFA.entities.Demande;
import com.example.PFA.entities.User;
import com.example.PFA.repositories.DemandeRepository;
import com.example.PFA.repositories.UserRepository;
import com.example.PFA.states.Pending;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        user.setDemandes(new ArrayList<>());
        user = userRepository.save(user);

        // Create and save the Demande
        Demande demande = new Demande();
        demande.setState(new Pending());
        demande.setUser(user);
        demande.setCodeTimbre(formData.getCodeTimbre());
        demande.setCnie(formData.getCnie());
        demande.setNom(formData.getNom());
        demande.setPrenom(formData.getPrenom());
        demande.setNomArabe(formData.getNomArabe());
        demande.setPrenomArabe(formData.getPrenomArabe());
        demande.setJourNaissance(formData.getJourNaissance());
        demande.setMoisNaissance(formData.getMoisNaissance());
        demande.setAnneeNaissance(formData.getAnneeNaissance());
        demande.setLieuNaissance(formData.getLieuNaissance());
        demande.setPaysNaissance(formData.getPaysNaissance());
        demande.setTelephone(formData.getTelephone());
        demande.setEmail(formData.getEmail());
        demande.setAdressePostale(formData.getAdressePostale());
        demande.setVille(formData.getVille());
        demande.setCodePostal(formData.getCodePostal());
        demande.setPays(formData.getPays());
        demande.setSexe(formData.getSexe());

        demande = demandeRepository.save(demande);

        // Add the demande to the user's list of demandes and save the user
        user.getDemandes().add(demande);
        userRepository.save(user);

        // Log the saved demande
        System.out.println("Saved Demande: " + demande);

        return demande;
    }
}
