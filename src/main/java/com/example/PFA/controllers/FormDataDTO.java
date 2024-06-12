package com.example.PFA.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
    private String lieuNaissance;
    private String paysNaissance;
    private String telephone;
    private String email;
    private String adressePostale;
    private String ville;
    private String codePostal;
    private String pays;
    private String sexe;

    // Getters and setters

    public String getCodeTimbre() { return codeTimbre; }
    public void setCodeTimbre(String codeTimbre) { this.codeTimbre = codeTimbre; }

    public String getCnie() { return cnie; }
    public void setCnie(String cnie) { this.cnie = cnie; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNomArabe() { return nomArabe; }
    public void setNomArabe(String nomArabe) { this.nomArabe = nomArabe; }

    public String getPrenomArabe() { return prenomArabe; }
    public void setPrenomArabe(String prenomArabe) { this.prenomArabe = prenomArabe; }

    public String getJourNaissance() { return jourNaissance; }
    public void setJourNaissance(String jourNaissance) { this.jourNaissance = jourNaissance; }

    public String getMoisNaissance() { return moisNaissance; }
    public void setMoisNaissance(String moisNaissance) { this.moisNaissance = moisNaissance; }

    public String getAnneeNaissance() { return anneeNaissance; }
    public void setAnneeNaissance(String anneeNaissance) { this.anneeNaissance = anneeNaissance; }

    public String getLieuNaissance() { return lieuNaissance; }
    public void setLieuNaissance(String lieuNaissance) { this.lieuNaissance = lieuNaissance; }

    public String getPaysNaissance() { return paysNaissance; }
    public void setPaysNaissance(String paysNaissance) { this.paysNaissance = paysNaissance; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAdressePostale() { return adressePostale; }
    public void setAdressePostale(String adressePostale) { this.adressePostale = adressePostale; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }

    public String getSexe() { return sexe; }
    public void setSexe(String sexe) { this.sexe = sexe; }
}
