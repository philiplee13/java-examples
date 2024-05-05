package com.example.kafka.service;

// spring web imports
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

// logging imports
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

// kafka imports
import org.springframework.kafka.core.KafkaTemplate;

@Service
public class UserProducer {

    private static final Logger logger = LoggerFactory.getLogger(UserProducer.class);
    private static final String TOPIC = "users";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("#### -> Producing message -> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
    }

}
