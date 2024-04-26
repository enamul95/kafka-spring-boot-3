package com.kafka.example.service;

import com.kafka.example.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

   // @KafkaListener(topics = "jt-demo-1",groupId = "jt-group-4")
    @KafkaListener(topics = "en1",groupId = "en1-group1")
    public void consumeEvents(CustomerDto customer) {
        log.info("consumer consume the events {} ", customer.toString());
    }



    //@KafkaListener(topics = "jt-demo-1",groupId = "jt-group-4")

    @KafkaListener(topics = "en1",groupId = "en1-group1")
    public void consume1(String message){
        log.info("consumer1 consume the message {} ",message);
    }

   /* @KafkaListener(topics = "java-topic-demo-5",groupId = "jt-group-demo-5")
    public void consume1(String message){
        log.info("consumer1 consume the message {} ",message);
    }

    @KafkaListener(topics = "java-topic-demo-5",groupId = "jt-group-demo-5")
    public void consume2(String message){
        log.info("consumer2 consume the message {} ",message);
    }

    @KafkaListener(topics = "java-topic-demo-5",groupId = "jt-group-demo-5")
    public void consume3(String message){
        log.info("consumer3 consume the message {} ",message);
    }

    @KafkaListener(topics = "java-topic-demo-5",groupId = "jt-group-demo-5")
    public void consume4(String message){
        log.info("consumer4 consume the message {} ",message);
    }
    */
}
