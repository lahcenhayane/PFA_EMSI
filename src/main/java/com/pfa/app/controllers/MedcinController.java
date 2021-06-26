package com.pfa.app.controllers;

import com.pfa.app.services.IMedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/medcin"})
public class MedcinController {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Autowired
    IMedcinService medcinService;

    @GetMapping
    public String Home(){
        return "Medcin/index";
    }


}
