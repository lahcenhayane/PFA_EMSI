package com.pfa.app.Entities;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Document(collection = "secretaires")
public class SecretaireEntity {

    private String id;
    private String salaire;
    private Date create_at;

    private UserEntity user;

    public SecretaireEntity() {
        this.create_at = new Date();
    }

    public SecretaireEntity(String id, String salaire, Date create_at, UserEntity user) {
        this.id = id;
        this.salaire = salaire;
        this.create_at = new Date();
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getSalaire() {
        return salaire;
    }

    public void setSalaire(String salaire) {
        this.salaire = salaire;
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
