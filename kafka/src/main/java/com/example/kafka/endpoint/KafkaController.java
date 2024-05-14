package com.example.kafka.endpoint;

// spring web imports
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import com.example.kafka.service.UserProducer;
import com.example.kafka.domain.User;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final UserProducer userProducer;

    // generic health check - should probably check consume and producer health
    // maybe check broker health
    @GetMapping(value = "/health")
    public Boolean healthCheck() {
        return true;
    }

    public KafkaController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    // get list of all topics in broker
    @GetMapping(value = "list")
    public Boolean getAllTopics() {
        return true;
    }

    @PostMapping(value = "/publish")
    public ResponseEntity<String> sendMessage(@RequestBody User user) { // <- should you map the request body like this?
                                                                        // or
        /*
         * should you create the obj first and then send?
         */
        System.out.println(String.format("user is -> %s", user));
        userProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to kafka topic");
    }

}
