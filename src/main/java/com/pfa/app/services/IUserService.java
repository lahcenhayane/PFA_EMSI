package com.pfa.app.services;

import com.pfa.app.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;

public interface IUserService extends UserDetailsService {

    void createPatient(UserDto userDto) throws ParseException;
}
