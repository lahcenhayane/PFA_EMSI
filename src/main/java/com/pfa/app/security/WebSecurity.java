package com.pfa.app.security;


import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    IUserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().and()
            .authorizeRequests()
                .antMatchers("/login","/registration", "/", "/index", "/createPatient",
                                        "/css/**", "/js/**").permitAll()
                .antMatchers("/medcin").hasRole("Medcin")
                .antMatchers("/patient").hasAnyRole("Patient","Medcin")
                .antMatchers("/secretaire").hasAnyRole("Secretaire","Medcin")
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/home")
                .failureUrl("/login")
                .and()
            .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true);
    }
}
