/*
 * This file should only consume the messages from a given topic
 * It should consume a message
 * Validate the data
 * And then send to where else
 */

package com.example.kafka.service;

// spring web imports
import org.springframework.stereotype.Service;

// kafka imports
import com.example.kafka.service.UserProducer;
import org.springframework.kafka.annotation.KafkaListener;

// logging imports
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.io.IOException;

import com.example.kafka.domain.User;

@Service
public class UserConsumer {

    private final Logger logger = LoggerFactory.getLogger(UserProducer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consumeUserMessages(User user) throws IOException {
        logger.info(String.format("Json message recieved -> %s", user));
    }

}
