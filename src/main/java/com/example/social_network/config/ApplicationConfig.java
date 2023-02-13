//package com.example.social_network.config;
//
//import com.example.social_network.repository.ClientRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
///**
// * @author Nick Musinov e-mail:n.musinov@gmail.com
// * 18.01.2023
// */
//@Configuration
//@RequiredArgsConstructor
//public class ApplicationConfig {
//    private final ClientRepository repository;
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return username -> repository.findClientByName(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//}
