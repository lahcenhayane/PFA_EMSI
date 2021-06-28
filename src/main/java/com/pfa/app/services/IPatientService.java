package com.pfa.app.services;

import com.pfa.app.Entities.RdvEntity;

import java.util.List;
import java.util.Optional;

public interface IPatientService {

    void createRdv(RdvEntity rdv);

    List<RdvEntity> getAllRDV();

    RdvEntity showrdv(long id);

    void terminerRdv(long id);
}
