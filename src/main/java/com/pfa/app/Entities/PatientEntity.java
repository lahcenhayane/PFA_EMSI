package com.pfa.app.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "patients")
public class PatientEntity {
    @Id
    private String id;
    private String cin;
    private String ville;
    private String profession;
    private String motif;
    private Date create_at;

    private UserEntity user;

    public PatientEntity() {
        this.create_at = new Date();
    }

    public PatientEntity(String id, String cin, String ville, String profession, String motif, Date create_at, UserEntity user) {
        this.id = id;
        this.cin = cin;
        this.ville = ville;
        this.profession = profession;
        this.motif = motif;
        this.create_at = new Date();
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
