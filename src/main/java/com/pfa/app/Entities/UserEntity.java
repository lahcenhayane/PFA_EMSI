package com.pfa.app.Entities;


import com.pfa.app.enums.Roles;
import com.pfa.app.enums.Sexe;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.processing.Generated;
import java.util.Date;

@Document(collection = "users")
public class UserEntity {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String address;
    private String email;
    private String password;
    private Sexe sexe;
    private String tel;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateNaissance;
    private Roles role;
    private Date create_at;
    private PatientEntity patient;
    private SecretaireEntity secretaire;
    private MedcinEntity medcin;

    public UserEntity() {
        this.create_at = new Date();
    }

    public UserEntity(String id, String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role, Date create_at, MedcinEntity medcin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.create_at = new Date();
        this.medcin = medcin;
    }

    public UserEntity(String id, String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role, Date create_at, SecretaireEntity secretaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.create_at = new Date();
        this.secretaire = secretaire;
    }

    public UserEntity(String id, String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role, Date create_at, PatientEntity patient) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.address = address;
        this.email = email;
        this.password = password;
        this.sexe = sexe;
        this.tel = tel;
        this.dateNaissance = dateNaissance;
        this.role = role;
        this.create_at = new Date();
        this.patient = patient;
    }

    public String getId() {
        return id;
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

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public SecretaireEntity getSecretaire() {
        return secretaire;
    }

    public void setSecretaire(SecretaireEntity secretaire) {
        this.secretaire = secretaire;
    }

    public MedcinEntity getMedcin() {
        return medcin;
    }

    public void setMedcin(MedcinEntity medcin) {
        this.medcin = medcin;
    }
}
