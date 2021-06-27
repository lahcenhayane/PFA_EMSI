package com.pfa.app.services.impl;

import com.pfa.app.Entities.UserEntity;
import com.pfa.app.enums.Roles;
import com.pfa.app.repositories.UserRepository;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);
        return new User(user.getEmail(), user.getPassword(), AuthorityUtils.createAuthorityList("ROLE_"+user.getRole().name()));
    }

    @Override
    public void createPatient(UserEntity user) throws ParseException {

        UserEntity findUserByEmail = userRepository.findByEmail(user.getEmail());
        if (findUserByEmail != null) throw new RuntimeException("User Already Exist "+user.getEmail());

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(Roles.Patient);
        user.getPatient().setUser(user);

        userRepository.save(user);
    }

    @Override
    public String findPatient(String email) {
        UserEntity user = userRepository.findByEmail(email);
        if (user == null) throw new UsernameNotFoundException("User Not Found "+email);
        return user.getPatient().getCin();
    }

}
