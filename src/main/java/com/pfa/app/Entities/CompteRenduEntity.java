package com.pfa.app.Entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "compterendu")
public class CompteRenduEntity {
    @Id @GeneratedValue
    private long id;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rdv_id", nullable = false)
    private RdvEntity rdv;

    @Column(nullable = false)
    private Date create_at = new Date();

    public CompteRenduEntity() {
    }

    public CompteRenduEntity(String description, RdvEntity rdv) {
        this.description = description;
        this.rdv = rdv;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RdvEntity getRdv() {
        return rdv;
    }

    public void setRdv(RdvEntity rdv) {
        this.rdv = rdv;
    }

    public Date getCreate_at() {
        return create_at;
    }
}
