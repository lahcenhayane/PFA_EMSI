package com.pfa.app.services;

import com.pfa.app.Entities.UserEntity;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;

public interface IUserService extends UserDetailsService {

    void createPatient(UserEntity userEntity) throws ParseException;

    long findPatient(String email);
}
