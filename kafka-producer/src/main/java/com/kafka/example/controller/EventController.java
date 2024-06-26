package com.kafka.example.controller;

import com.kafka.example.dto.CustomerDto;
import com.kafka.example.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {

            for(int i = 0;i<=10000;i++) {
                publisher.sendMessageToTopic(message+" : "+i);
            }
            return ResponseEntity.ok("Message published successful");

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @PostMapping("/publish")
    public void sendEvents(@RequestBody CustomerDto customerDto){
        publisher.sendEventToTopic(customerDto);
    }

}
