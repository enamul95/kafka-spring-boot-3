package com.kafka.producer.service;

import com.kafka.producer.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String,Object> template;


    public void sendMessageToTopic(String message){
        CompletableFuture<SendResult<String, Object>> future = template.send("java-topic-demo-5", message);

        future.whenComplete((result,ex)->{
            if(ex == null){
                System.out.println("Sent Message=["+message+"] with offset=["+result.getRecordMetadata().hasOffset()+"]");
            }else{
                System.out.println("Unable to send message=["+message+"] due to : "+ex.getMessage());
            }
        });
    }

    public void sendEventToTopic(CustomerDto customerDto){

        try {
            CompletableFuture<SendResult<String, Object>> future = template.send("java-topic-demo-6", customerDto.toString());

            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent Message=[" + customerDto.toString() + "] with offset=[" + result.getRecordMetadata().hasOffset() + "]");
                } else {
                    System.out.println("Unable to send message=[" + customerDto.toString() + "] due to : " + ex.getMessage());
                }
            });
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }


}
