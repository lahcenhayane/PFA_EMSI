package com.pfa.app.controllers;

import com.pfa.app.Entities.CompteRenduEntity;
import com.pfa.app.Entities.MedcinEntity;
import com.pfa.app.Entities.PatientEntity;
import com.pfa.app.Entities.RdvEntity;
import com.pfa.app.enums.RendezVous;
import com.pfa.app.services.IMedcinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Controller
@RequestMapping(value = {"/medcin"})
public class MedcinController {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Autowired
    IMedcinService medcinService;

    @GetMapping
    public String Home(Model model){
        List<PatientEntity>  patientEntities = medcinService.getAllPatient();
        model.addAttribute("patients", patientEntities);
        return "Medcin/index";
    }

    @GetMapping("/rdv")
    public String rdv(Model model){
        List<RdvEntity> rdvEntities = medcinService.getAllRdv();
        model.addAttribute("rdvEntities", rdvEntities);
        return "Medcin/rdv";
    }



    @GetMapping("/{id}/show")
    public String show(Model model, @PathVariable long id){
        PatientEntity patientEntity = medcinService.getMedcin(id);
        model.addAttribute("patient", patientEntity);
        return "Medcin/show";
    }

    @GetMapping("/{id}/show/compterendu")
    public String showCompteRendu(Model model, @PathVariable long id){
        RdvEntity rdv = medcinService.getCompteRendu(id);
        model.addAttribute("rdv", rdv);
        return "Medcin/compteRendu";
    }

    @GetMapping("/{id}/showcompterendu")
    public String createCompteRendu(){

        return "Medcin/showCompteRendu";
    }

    @PostMapping("/{id}/delete")
    public String deletePatient(@PathVariable long id){
        medcinService.deletePatient(id);
        return "redirect:/";
    }

    @PostMapping("{id}/deleterdv")
    public String deleterdv(@PathVariable long id){
        medcinService.deletePatient(id);
        return "redirect:/medcin/rdv";
    }
    @GetMapping("/{id}/setstatus")
    public String SetStatus(@PathVariable long id, @RequestParam(value = "status") String rendezVous){
        medcinService.setStatusRdv(id, rendezVous);
        return "redirect:/medcin/rdv";
    }
}
