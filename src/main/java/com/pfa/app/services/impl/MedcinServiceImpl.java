package com.pfa.app.services.impl;

import com.pfa.app.Entities.CompteRenduEntity;
import com.pfa.app.Entities.PatientEntity;
import com.pfa.app.Entities.RdvEntity;
import com.pfa.app.enums.RendezVous;
import com.pfa.app.repositories.*;
import com.pfa.app.services.IMedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class MedcinServiceImpl implements IMedcinService {

    @Autowired
    MedcinRepository medcinRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    CompteRenduRepository compteRenduRepository;
    @Autowired
    RdvRepository rdvRepository;
    @Autowired
    UserRepository userRepository;


    @Override
    public List<PatientEntity> getAllPatient() {
        List<PatientEntity> patientEntities = patientRepository.findAll(Sort.unsorted());
        return patientEntities;
    }

    @Override
    public PatientEntity getMedcin(long id) {
        PatientEntity patient = patientRepository.findById(id).get();
        return patient;
    }

    @Override
    public RdvEntity getCompteRendu(long id) {
        RdvEntity rdvEntity = rdvRepository.findById(id).get();
        return rdvEntity;
    }

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<RdvEntity> getAllRdv() {
        List<RdvEntity> rdvEntities = rdvRepository.findAll();
        return rdvEntities;
    }

    @Override
    public void setStatusRdv(long id, String rendezVous) {
        RdvEntity rdvEntity = rdvRepository.findById(id).get();
        RendezVous rendez = RendezVous.valueOf(rendezVous);
        rdvEntity.setStatus(rendez);
        rdvRepository.save(rdvEntity);
    }


}
