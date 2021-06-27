package com.pfa.app.services.impl;

import com.pfa.app.repositories.PatientRepository;
import com.pfa.app.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public void findPatient(String email) {

    }
}
