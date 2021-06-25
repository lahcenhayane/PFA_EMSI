package com.pfa.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"", "/","/index"})
    public String index(Model model){
        model.addAttribute("index", "hello Index");
        return "index";
    }
}
