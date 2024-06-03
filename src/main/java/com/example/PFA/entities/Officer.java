package com.example.PFA.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "officer")
@AllArgsConstructor
@NoArgsConstructor
public class Officer {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private String id;
    private String name;
    private String surname;

}
