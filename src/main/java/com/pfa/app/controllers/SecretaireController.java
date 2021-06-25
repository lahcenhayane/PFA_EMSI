package com.pfa.app.controllers;

import com.pfa.app.services.ISecretaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/secretaire"})
public class SecretaireController {

    @Autowired
    ISecretaireService secretaireService;
}
