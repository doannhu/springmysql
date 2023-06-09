package com.example.accessingdatamysql.Configuration;


import com.example.accessingdatamysql.Service.UserInfoUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
        return new UserInfoUserDetailsService();
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/products/welcome",
                                            "/products/new",
                                            "/users/new", 
                                            "/room/add", 
                                            "/demo/add", 
                                            "/room/all-pageable", 
                                            "/room/all-pageable-v2",
                                            "/room/all-pageable-v3", 
                                            "/room/all-dto",
                                            "/image/**", 
                                            "/create-checkout-session/room/**", 
                                            "/owner/register", 
                                            "/owner/update/**", 
                                            "/owner/all", 
                                            "/room/all").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers("/products/**", "/room/{id}", "room/update/**")
                .authenticated().and().httpBasic().and().build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }



}
