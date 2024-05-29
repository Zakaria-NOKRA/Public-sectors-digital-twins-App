package com.example.PFA.repositories;

import com.example.PFA.entities.user;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<user, String> {
}
