package com.luv2code.com.RabbitMQexaample.consumer;

import com.luv2code.com.RabbitMQexaample.dto.OrderStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.luv2code.com.RabbitMQexaample.Constants.constants.QUEUE;

@Component
public class User {

    @RabbitListener(queues = QUEUE)  //enables us to consume the messages
    public void consumeMessageFromQueue(OrderStatus orderStatus) {
        System.out.println("Message Received from Queue: " + orderStatus);
    }
}
