package com.kafka.example.service;

import com.kafka.example.dto.CustomerDto;
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
        CompletableFuture<SendResult<String, Object>> future = template.send("en1", message);

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
            CompletableFuture<SendResult<String, Object>> future = template.send("en1", customerDto);
            future.whenComplete((result, ex) -> {
                if (ex == null) {
                    System.out.println("Sent message=[" + customerDto.toString() +
                            "] with offset=[" + result.getRecordMetadata().offset() + "]");
                } else {
                    System.out.println("Unable to send message=[" +
                            customerDto.toString() + "] due to : " + ex.getMessage());
                }
            });

        } catch (Exception ex) {
            System.out.println("ERROR : "+ ex.getMessage());
        }
    }


}
