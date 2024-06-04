package com.example.PFA.controllers;

import com.example.PFA.entities.Demande;
import com.example.PFA.services.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    @Autowired
    private DemandeService demandeService;

    @PostMapping
    public Demande createDemande() {
        return demandeService.createDemande();
    }

    @GetMapping("/{id}")
    public Demande getDemande(@PathVariable String id) {
        return demandeService.getDemande(id).orElseThrow(() -> new RuntimeException("Demande not found"));
    }

    @PutMapping("/{id}/state")
    public Demande updateState(@PathVariable String id, @RequestParam String state) {
        return demandeService.updateState(id, state);
    }
}
