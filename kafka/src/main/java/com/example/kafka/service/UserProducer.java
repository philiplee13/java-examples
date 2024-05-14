/*
 * This file should handle producing a message to a given topic
 * It should take in the data from the endpoint
 * Do whatever initial work
 * And then send to the consumer
 */

package com.example.kafka.service;

// spring web imports
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

// logging imports
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

// kafka imports
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

// java imports
import com.example.kafka.domain.User;

@Service
public class UserProducer {

    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void sendMessage(User user) {
        logger.info(String.format("User sent -> %s", user));
        kafkaTemplate.send("users", user);
    }

}
