package com.pfa.app.security;


import com.pfa.app.enums.Roles;
import com.pfa.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    IUserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
        //auth.inMemoryAuthentication().withUser("lahcenhayane@gmail.com").password(bCryptPasswordEncoder.encode("lahcenhayane")).roles(Roles.Patient.name());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/registration",
                                        "/createPatient",
                                        "/", "/index",
                                        "/css/**", "/js/**").permitAll()
                .antMatchers("/medcin/**").hasRole(Roles.Medcin.name())
                .antMatchers("/patient/**").hasAnyRole(Roles.Patient.name(),Roles.Medcin.name())
                .antMatchers("/secretaire/**").hasAnyRole(Roles.Secretaire.name(),Roles.Medcin.name())
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}
