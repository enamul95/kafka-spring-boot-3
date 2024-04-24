package com.kafka.consumer.service;

import com.kafka.consumer.dto.CustomerDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaMessageListener {

    @KafkaListener(topics = "java-topic-demo-6",groupId = "jt-group-demo-6")
    public void consumeEvents(CustomerDto customerDto){
        log.info("consumer1 consume the events {} ",customerDto.toString());
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
