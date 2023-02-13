package com.example.social_network.controllers;

import com.example.social_network.entities.Client;
import com.example.social_network.entities.Message;
import com.example.social_network.repository.ClientRepository;
import com.example.social_network.services.ClientService;
import com.example.social_network.services.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 09.01.2023
 */
@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final ClientRepository clientRepository;
    private final ClientService clientService;

    @RequestMapping("/main")
    public String getTwits(Model model, OAuth2AuthenticationToken authenticationToken) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth);
        if (!auth.isAuthenticated() ||
                clientRepository.findClientByEmail(authenticationToken.getPrincipal().getAttribute("email")) == null) {
            clientService.createNewOAuthClient(authenticationToken);
        }
        model.addAttribute("messages", messageService.getMessages());
        return "messages";
    }

    @RequestMapping("/test")
    public String test(Model model,OAuth2AuthenticationToken authenticationToken) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth.isAuthenticated()) {
            model.addAttribute("client",
                    clientRepository.findClientByEmail(authenticationToken.getPrincipal().getAttribute("email")));
            model.addAttribute("messages", messageService.getMessages());
            model.addAttribute("message", new Message());
        }
        return "main";
    }

//    @GetMapping("/add-message")
//    public String addMsg(Model model,OAuth2AuthenticationToken authenticationToken) {
//        model.addAttribute("message",new Message());
//        return "add-msg";
//    }

    @PostMapping("/test")
    public String newMessage(@ModelAttribute("message") Message message,OAuth2AuthenticationToken authenticationToken) {
        message.setClient(clientRepository.findClientByEmail(authenticationToken.getPrincipal().getAttribute("email")));
        if (!message.getTwit().isEmpty()) {
            messageService.addMessage(message);
        }
        return "redirect:/api/test";
    }

//    @RequestMapping("getAllTwitsById")
//    public List<Message> getTwitsById(@RequestParam Long id) {
//        return messageService.getMessagesByClientId(id);
//    }
}
