package com.pfa.app.controllers;

import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping(value = {"/login"})
    public String showLogin(Model model){
        return "login";
    }

    @PostMapping("/login")
    public String login(Model model){
        return "redirect:index";
    }


    @GetMapping(value = {"/registration"})
    public String showRegistration(Model model){
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(Model model){
        return "login";
    }

}
