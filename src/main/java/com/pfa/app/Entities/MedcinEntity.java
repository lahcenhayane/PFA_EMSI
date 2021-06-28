package com.pfa.app.Entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "medecins")
public class MedcinEntity {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private Date create_at;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id", nullable = false)
    private UserEntity user;

    public MedcinEntity() {
        this.create_at = new Date();
    }

    public MedcinEntity(List<CompteRenduEntity> compteRendu) {
        this.create_at = new Date();
    }

    public MedcinEntity(UserEntity user) {
        this.create_at = create_at;
        this.user = user;
    }

    public long getId() {
        return id;
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
