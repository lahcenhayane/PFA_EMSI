package com.pfa.app.controllers;

import com.pfa.app.Entities.UserEntity;
import com.pfa.app.enums.Roles;
import com.pfa.app.enums.Sexe;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UserController {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    @Autowired
    IUserService userService;

    @GetMapping(value = {"/login"})
    public String showLogin(Model model){
//        model.addAttribute("user", authentication.getDetails());
//        if (authentication.getPrincipal() != null){
//            return "index";
//        }
        return "login";
    }

    @GetMapping(value = {"/registration"})
    public String showRegistration(Model model){
        UserEntity userEntity = new UserEntity();
        model.addAttribute("user", userEntity);
        return "registration";
    }

    @PostMapping("/createPatient")
    public String registration(UserEntity userEntity) throws ParseException {
        userService.createPatient(userEntity);
        return "redirect:/login";
    }

}
