package com.pfa.app.Entities;

import com.pfa.app.enums.CouvertureSociale;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "patients")
public class PatientEntity {
    @Id @GeneratedValue
    private long id;
    @Column(nullable = false, unique = true)
    private String cin;
    private String ville;
    private String profession;
    private String motif;
    @CreatedDate
    @Column(nullable = false)
    private Date create_at;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CouvertureSociale couvertureSociale;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<RdvEntity> rdvs;

    @OneToOne
    @JoinColumn(name = "users_id", nullable = false)
    private UserEntity user;

    public PatientEntity() {
        this.create_at = new Date();
    }

    public PatientEntity(String cin, String ville, String profession, String motif, Date create_at, CouvertureSociale couvertureSociale, List<RdvEntity> rdvs) {
        this.cin = cin;
        this.ville = ville;
        this.profession = profession;
        this.motif = motif;
        this.create_at = create_at;
        this.couvertureSociale = couvertureSociale;
        this.rdvs = rdvs;
    }

    public PatientEntity(long id, String cin, String ville, String profession, String motif, CouvertureSociale couvertureSociale, UserEntity user) {
        this.id = id;
        this.cin = cin;
        this.ville = ville;
        this.profession = profession;
        this.motif = motif;
        this.create_at = new Date();
        this.couvertureSociale = couvertureSociale;
        this.user = user;
    }

    public long getId() {
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

    public CouvertureSociale getCouvertureSociale() {
        return couvertureSociale;
    }

    public void setCouvertureSociale(CouvertureSociale couvertureSociale) {
        this.couvertureSociale = couvertureSociale;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<RdvEntity> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<RdvEntity> rdvs) {
        this.rdvs = rdvs;
    }
}
