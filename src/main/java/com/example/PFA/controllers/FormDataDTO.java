package com.example.PFA.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormDataDTO {

    private String codeTimbre;
    private String cnie;
    private String nom;
    private String prenom;
    private String nomArabe;
    private String prenomArabe;
    private String jourNaissance;
    private String moisNaissance;
    private String anneeNaissance;
    private boolean noDateNaissance;
    private String lieuNaissance;
    private String paysNaissance;
    private String telephone;
    private String email;
    private String adressePostale;
    private String ville;
    private String codePostal;
    private String sexe;
}
