package com.pfa.app.services.impl;

import com.pfa.app.Entities.UserEntity;
import com.pfa.app.dto.UserDto;
import com.pfa.app.enums.Roles;
import com.pfa.app.repositories.UserRepository;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user != null) throw new UsernameNotFoundException(email);
        return new User(user.getEmail(), bCryptPasswordEncoder.encode(user.getPassword()), new ArrayList<>());
    }

    @Override
    public void createPatient(UserDto userDto) throws ParseException {

        UserEntity userEntity = new UserEntity();
        userEntity.setNom(userDto.getNom());
        userEntity.setPrenom(userDto.getPrenom());
        userEntity.setAddress(userDto.getAddress());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userEntity.setSexe(userDto.getSexe());
        userEntity.setTel(userDto.getTel());
        userEntity.setDateNaissance(userDto.getDateNaissance());
        userEntity.setRole(Roles.Patient);

        UserEntity findUserByEmail = userRepository.findByEmail(userDto.getEmail());
        if (findUserByEmail != null) throw new UsernameNotFoundException(userDto.getEmail());
        userRepository.save(userEntity);
    }
}
