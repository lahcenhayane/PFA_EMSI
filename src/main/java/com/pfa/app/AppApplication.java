package com.pfa.app;

import com.pfa.app.Entities.MedcinEntity;
import com.pfa.app.Entities.UserEntity;
import com.pfa.app.enums.Roles;
import com.pfa.app.enums.Sexe;
import com.pfa.app.repositories.MedcinRepository;
import com.pfa.app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class AppApplication implements CommandLineRunner{

    @Autowired
    UserRepository userRepository;
    @Autowired
    MedcinRepository medcinRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(String... args) throws Exception {
        UserEntity userEntity = new UserEntity();
        userEntity.setNom("Lahcen");
        userEntity.setPrenom("Hayane");
        userEntity.setAddress("Hassan II");
        userEntity.setEmail("lahcenhayane@gmail.com");
        userEntity.setPassword(bCryptPasswordEncoder().encode("lahcenhayane"));
        userEntity.setSexe(Sexe.Homme);
        userEntity.setTel("0656341096");
        userEntity.setDateNaissance(new Date());
        userEntity.setRole(Roles.Medcin);

        //userEntity.getMedcin().setCreate_at(new Date());
//        userEntity.getMedcin().setUser(userEntity);


        UserEntity user = userRepository.findByEmail("lahcenhayane@gmail.com");
        if (user == null){
            userRepository.save(userEntity);
        }
    }
}
