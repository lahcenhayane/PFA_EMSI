package com.pfa.app.controllers;

import com.pfa.app.services.IMedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/medcin"})
public class MedcinController {

    @Autowired
    IMedcinService medcinService;
    @GetMapping
    public String Home(){
        return "Medcin/index";
    }
}
