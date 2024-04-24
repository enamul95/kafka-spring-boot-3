package com.kafka.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    private int id;
    private String name;
    private String email;
    private String contactNo;

}
