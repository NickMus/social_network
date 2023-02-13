package com.example.social_network.services;

import com.example.social_network.entities.Client;
import com.example.social_network.entities.Message;
import com.example.social_network.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 09.01.2023
 */
@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;

    public List<Message> getMessages() {
        return messageRepository.findAllByOrderByIdDesc();
    }

    public void addMessage(Message msg) {
//        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Locale loc = new Locale("ru", "RU");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, loc);
        DateFormat timeFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, loc);
        String date = dateFormat.format(new Date());
        String time = timeFormat.format(new Date());
        msg.setDate(date);
        msg.setTime(time);

        messageRepository.save(msg);
    }

//    public List<Message> getMessagesByClientId(Long id) {
//        return messageRepository.findMessagesByClient_Id(id);
//    }
}
