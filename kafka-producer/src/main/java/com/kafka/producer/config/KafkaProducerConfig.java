package com.kafka.producer.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createNewTopic(){
        return new NewTopic("java-topic-demo-6",3,(short) 1);
    }
}
