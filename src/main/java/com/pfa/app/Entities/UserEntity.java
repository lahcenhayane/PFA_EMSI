package com.pfa.app.Entities;


import com.pfa.app.enums.Roles;
import com.pfa.app.enums.Sexe;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;
    private String nom;
    private String prenom;
    private String address;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String tel;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateNaissance;
    @Enumerated(EnumType.STRING)
    private Roles role;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(nullable = false)
    private Date create_at;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private PatientEntity patient;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private SecretaireEntity secretaire;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
    private MedcinEntity medcin;

    public UserEntity() {
        this.create_at = new Date();
    }

    public UserEntity(long id, String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role, MedcinEntity medcin) {
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

    public UserEntity(long id, String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role, SecretaireEntity secretaire) {
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

    public UserEntity(long id, String nom, String prenom, String address, String email, String password, Sexe sexe, String tel, Date dateNaissance, Roles role, PatientEntity patient) {
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

    public long getId() {
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
