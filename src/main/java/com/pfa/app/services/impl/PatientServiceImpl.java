package com.pfa.app.services.impl;

import com.pfa.app.Entities.PatientEntity;
import com.pfa.app.Entities.RdvEntity;
import com.pfa.app.Entities.UserEntity;
import com.pfa.app.enums.RendezVous;
import com.pfa.app.repositories.PatientRepository;
import com.pfa.app.repositories.RdvRepository;
import com.pfa.app.repositories.UserRepository;
import com.pfa.app.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    RdvRepository rdvRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void createRdv(RdvEntity rdv) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = "";
        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        }
        UserEntity user = userRepository.findByEmail(email);

        rdv.setPatient(user.getPatient());
        rdv.setStatus(RendezVous.Attente);
        rdv.setRetard(false);
        rdv.setCancel(false);

        rdvRepository.save(rdv);

    }

    @Override
    public List<RdvEntity> getAllRDV() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = "";
        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        }

        List<RdvEntity> rdvEntity = userRepository.findByEmail(email).getPatient().getRdvs();
        return rdvEntity;
    }

    @Override
    public RdvEntity showrdv(long id) {
        RdvEntity rdvEntity = rdvRepository.findById(id).get();
        return rdvEntity;
    }

    @Override
    public void terminerRdv(long id) {
        RdvEntity rdvEntity = rdvRepository.findById(id).get();
        rdvEntity.setCancel(true);
        rdvRepository.save(rdvEntity);
    }

}
