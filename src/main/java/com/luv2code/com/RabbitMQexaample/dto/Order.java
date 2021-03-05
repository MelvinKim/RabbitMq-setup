package com.luv2code.com.RabbitMQexaample.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    public String orderId;
    public String name;
    public int qty;
    private double price;
}
