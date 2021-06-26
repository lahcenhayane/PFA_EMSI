package com.pfa.app.controllers;

import com.pfa.app.dto.LoginUserDto;
import com.pfa.app.dto.UserDto;
import com.pfa.app.enums.Roles;
import com.pfa.app.enums.Sexe;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    IUserService userService;

    @GetMapping(value = {"/login"})
    public String showLogin(Model model){
        return "login";
    }

    @GetMapping(value = {"/registration"})
    public String showRegistration(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @PostMapping("/createPatient")
    public String registration(UserDto userDto) throws ParseException {
        userService.createPatient(userDto);
        return "redirect:/login";
    }

}
