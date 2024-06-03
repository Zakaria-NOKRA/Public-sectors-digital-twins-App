package com.example.PFA.repositories;

import com.example.PFA.entities.Officer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficerRepository extends MongoRepository<Officer, String> {
}
