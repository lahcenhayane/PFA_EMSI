package com.pfa.app.Entities;


import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "secretaires")
public class SecretaireEntity {
    @Id @GeneratedValue
    private long id;
    private float salaire;
    @CreatedDate
    @Column(nullable = false)
    private Date create_at;

    @OneToOne
    @JoinColumn(name = "users_id", nullable = false)
    private UserEntity user;

    public SecretaireEntity() {
        this.create_at = new Date();
    }

    public SecretaireEntity(long id, float salaire, Date create_at, UserEntity user) {
        this.id = id;
        this.salaire = salaire;
        this.create_at = new Date();
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
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
