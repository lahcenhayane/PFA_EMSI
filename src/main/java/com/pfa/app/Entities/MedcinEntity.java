package com.pfa.app.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "medecins")
public class MedcinEntity {
    @Id
    @GeneratedValue
    private String id;
    @Column(nullable = false)
    private Date create_at;

    @OneToOne
    @JoinColumn(name = "users_id", nullable = false)
    private UserEntity user;

    public MedcinEntity() {

    }

    public MedcinEntity(String id, UserEntity user) {
        this.id = id;
        this.user = user;
    }

    public String getId() {
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
