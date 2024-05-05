package com.example.kafka.endpoint;

// spring web imports
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

// kafka imports
import com.example.kafka.service.UserProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final UserProducer userProducer;

    @GetMapping(value = "/health")
    public Boolean healthCheck() {
        return true;
    }

    @Autowired
    KafkaController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody String message) {
        this.userProducer.sendMessage(message);
    }

}
