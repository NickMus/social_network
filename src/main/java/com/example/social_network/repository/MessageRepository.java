package com.example.social_network.repository;

import com.example.social_network.entities.Message;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Nick Musinov e-mail:n.musinov@gmail.com
 * 09.01.2023
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    public List<Message> findAllByOrderByIdDesc();


}
