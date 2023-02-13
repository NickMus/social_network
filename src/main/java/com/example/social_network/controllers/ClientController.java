package com.example.social_network.controllers;

import com.example.social_network.repository.ClientRepository;
import com.example.social_network.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 12.01.2023
 */
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientRepository clientRepository;
    private final ClientService clientService;

//    @GetMapping("/")
//    public String welcomePage(OAuth2AuthenticationToken authenticationToken) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(auth);
//        if (!auth.isAuthenticated()||
//                clientRepository.findClientByEmail(authenticationToken.getPrincipal().getAttribute("email")).isEmpty()) {
//            clientService.createNewOAuthClient(authenticationToken);
//        }
//        System.out.println(auth);
//        return "welcome-page.html";
//    }

//    @GetMapping("/index")
//    public String index(OAuth2AuthenticationToken authenticationToken) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(auth);
//        if (!auth.isAuthenticated()||
//                clientRepository.findClientByEmail(authenticationToken.getPrincipal().getAttribute("email")).isEmpty()) {
//            clientService.createNewOAuthClient(authenticationToken);
//        }
//        System.out.println(auth);
//        return "index.html";
//    }

}
