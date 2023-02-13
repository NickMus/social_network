package com.example.social_network.repository;

import com.example.social_network.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 12.01.2023
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

     Client findClientByEmail(String email);
}
