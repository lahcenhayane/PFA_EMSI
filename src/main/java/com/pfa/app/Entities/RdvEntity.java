package com.pfa.app.Entities;

import com.pfa.app.enums.RendezVous;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "rdv")
public class RdvEntity {
    @Id @GeneratedValue
    private long id;
    private RendezVous status;
    private Boolean cancel = false;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date create_at = new Date();

    @ManyToOne
    @JoinColumn(name = "patients_id")
    private PatientEntity patient;

    public RdvEntity() {
    }
}
