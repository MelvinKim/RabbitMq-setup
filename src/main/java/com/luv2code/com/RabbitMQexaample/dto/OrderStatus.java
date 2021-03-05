package com.luv2code.com.RabbitMQexaample.dto;

//we will return the order status to the end user

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderStatus {

    private Order order;
    private String status;  //progress, completed
    private String message;
}
