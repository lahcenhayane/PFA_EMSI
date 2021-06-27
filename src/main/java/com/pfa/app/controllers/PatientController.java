package com.pfa.app.controllers;

import com.pfa.app.services.IPatientService;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.ContentHandler;

@Controller
@RequestMapping(value = {"/patient"})
public class PatientController {

    @Autowired
    IUserService userService;

    @Autowired
    IPatientService patientService;

    @GetMapping
    public String index(){
        return "Patient/index";
    }

    @GetMapping("/rdv")
    public String rdv(Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = "";


        if (principal instanceof UserDetails) {
            email = ((UserDetails)principal).getUsername();
        }
        String cinPatient = userService.findPatient(email);
        model.addAttribute("cinPateint", cinPatient);
        //patientService.findPatient(email);
        return "Patient/rdv";
    }
}
