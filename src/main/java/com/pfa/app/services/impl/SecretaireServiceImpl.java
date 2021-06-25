package com.pfa.app.services.impl;

import com.pfa.app.repositories.SecretaireRepository;
import com.pfa.app.services.ISecretaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecretaireServiceImpl implements ISecretaireService {

    @Autowired
    SecretaireRepository secretaireRepository;
}
