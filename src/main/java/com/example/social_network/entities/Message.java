package com.example.social_network.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 09.01.2023
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String twit;
    private String date;
    private String time;
    @ManyToOne
    private Client client;

}
