package com.example.PFA.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class user {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private String name;
    private String surname;
    private String phone;
    private String cin;
}
