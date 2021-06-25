package com.pfa.app.services.impl;

import com.pfa.app.repositories.MedcinRepository;
import com.pfa.app.services.IMedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedcinServiceImpl implements IMedcinService {

    @Autowired
    MedcinRepository medcinRepository;
}
