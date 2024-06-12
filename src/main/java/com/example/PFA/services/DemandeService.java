package com.example.PFA.services;

import com.example.PFA.entities.Demande;
import com.example.PFA.repositories.DemandeRepository;
import com.example.PFA.states.Approved;
import com.example.PFA.states.Pending;
import com.example.PFA.states.Refused;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private Pending pending;

    @Autowired
    private Approved approved;

    @Autowired
    private Refused refused;

    public Demande createDemande() {
        Demande demande = new Demande(pending);
        return demandeRepository.save(demande);
    }

    public Optional<Demande> getDemande(String id) {
        return demandeRepository.findById(id);
    }

    public Demande updateState(String id, String state) {
        Optional<Demande> demandeOptional = demandeRepository.findById(id);
        if (demandeOptional.isPresent()) {
            Demande demande = demandeOptional.get();
            switch (state.toLowerCase()) {
                case "approved":
                    demande.setState(approved);
                    break;
                case "refused":
                    demande.setState(refused);
                    break;
                case "pending":
                default:
                    demande.setState(pending);
                    break;
            }
            demande.applyState();
            return demandeRepository.save(demande);
        }
        throw new RuntimeException("Demande not found");
    }

    public List<Demande> findAll() {
        return demandeRepository.findAll();
    }
}
