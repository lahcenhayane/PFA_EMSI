package com.pfa.app.dto;

import com.pfa.app.Entities.MedcinEntity;
import com.pfa.app.Entities.PatientEntity;
import com.pfa.app.Entities.SecretaireEntity;
import com.pfa.app.enums.CouvertureSociale;
import com.pfa.app.enums.Roles;
import com.pfa.app.enums.Sexe;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserDto {

    private String nom;
    private String prenom;
    private String address;
    private String email;
    private String password;
    private Sexe sexe;
    private String tel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    private Roles role;

    private PatientDto patientDto;

    public UserDto() {
    }

    public UserDto(String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role) {
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.role = role;
    }

    public UserDto(String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role, PatientDto patientDto) {
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.patientDto = patientDto;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Sexe getSexe() {
        return sexe;
    }

    public void setSexe(Sexe sexe) {
        this.sexe = sexe;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public PatientDto getPatientDto() {
        return patientDto;
    }

    public void setPatientDto(PatientDto patientDto) {
        this.patientDto = patientDto;
    }
}
