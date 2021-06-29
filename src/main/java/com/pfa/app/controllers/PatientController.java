package com.pfa.app.controllers;

import com.pfa.app.Entities.PatientEntity;
import com.pfa.app.Entities.RdvEntity;
import com.pfa.app.repositories.RdvRepository;
import com.pfa.app.services.IPatientService;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.ContentHandler;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = {"/patient"})
public class PatientController {

    @Autowired
    IUserService userService;

    @Autowired
    IPatientService patientService;

    @GetMapping
    public String index(Model model){
        List<RdvEntity> RdvList = patientService.getAllRDV();
        model.addAttribute("listRdv", RdvList);

        RdvEntity rdv = new RdvEntity();
        model.addAttribute("rdv", rdv);

        return "Patient/index";
    }

    @PostMapping("/rdvnow")
    public String rdvnow(RdvEntity rdv){
        patientService.createRdv(rdv);
        return "redirect:/patient";
    }

    @GetMapping("/rdv/{id}/show")
    public String rdvShow(Model model, @PathVariable long id){
        RdvEntity rdv = patientService.showrdv(id);
        model.addAttribute("rdv", rdv);
        return "Patient/show";
    }

    @PostMapping("/rdv/{id}/terminer")
    public String rdvShow(@PathVariable long id){
        patientService.terminerRdv(id);
        return "redirect:/patient";
    }

}
