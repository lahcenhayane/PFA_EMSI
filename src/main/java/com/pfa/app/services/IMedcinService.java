package com.pfa.app.services;

import com.pfa.app.Entities.CompteRenduEntity;
import com.pfa.app.Entities.PatientEntity;
import com.pfa.app.Entities.RdvEntity;
import com.pfa.app.enums.RendezVous;

import java.util.List;

public interface IMedcinService {
    List<PatientEntity> getAllPatient();

    PatientEntity getMedcin(long id);

    RdvEntity getCompteRendu(long id);

    void deletePatient(long id);

    List<RdvEntity> getAllRdv();

    void setStatusRdv(long id, String rendezVous);

    RdvEntity getRdv(long id);

    void createCompteRendu(long id, CompteRenduEntity compteRendu);
}
