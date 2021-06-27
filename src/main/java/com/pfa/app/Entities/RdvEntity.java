package com.pfa.app.Entities;

import com.pfa.app.enums.RendezVous;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "rdv")
public class RdvEntity {
    @Id @GeneratedValue
    private long id;
    @Enumerated(EnumType.STRING)
    private RendezVous status;
    private Boolean cancel = false;
    private Boolean retard = false;
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date create_at = new Date();

    @ManyToOne
    @JoinColumn(name = "patients_id", nullable = false)
    private PatientEntity patient;

    public RdvEntity() {
    }

    public RdvEntity(RendezVous status, Boolean cancel, PatientEntity patient,Boolean retard) {
        this.retard = retard;
        this.status = status;
        this.cancel = cancel;
        this.patient = patient;
    }

    public long getId() {
        return id;
    }

    public RendezVous getStatus() {
        return status;
    }

    public void setStatus(RendezVous status) {
        this.status = status;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
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

    public Boolean getRetard() {
        return retard;
    }

    public void setRetard(Boolean retard) {
        this.retard = retard;
    }
}
