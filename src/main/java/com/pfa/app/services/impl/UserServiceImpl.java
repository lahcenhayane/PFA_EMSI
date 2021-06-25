package com.pfa.app.services.impl;

import com.pfa.app.Entities.UserEntity;
import com.pfa.app.repositories.UserRepository;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email);
        if (user != null) throw new UsernameNotFoundException(email);
        return new User("lahcen", "Hayane", new ArrayList<>());
    }
}
