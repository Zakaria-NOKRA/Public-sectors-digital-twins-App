package com.example.PFA.repositories;

import com.example.PFA.entities.Demande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandeRepository extends MongoRepository<Demande, String> {
}
