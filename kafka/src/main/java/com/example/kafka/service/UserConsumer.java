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

@Service
public class UserConsumer {

    private final Logger logger = LoggerFactory.getLogger(UserProducer.class);

    @KafkaListener(topics = "users", groupId = "group_id")
    public void consume(String message) throws IOException {
        logger.info(String.format("#### -> Consumed message -> %s", message));
    }
}
