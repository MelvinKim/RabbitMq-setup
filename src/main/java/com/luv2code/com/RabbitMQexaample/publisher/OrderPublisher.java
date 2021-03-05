package com.luv2code.com.RabbitMQexaample.publisher;

//expose the publisher as a rest endpoint

import com.luv2code.com.RabbitMQexaample.dto.Order;
import com.luv2code.com.RabbitMQexaample.dto.OrderStatus;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static com.luv2code.com.RabbitMQexaample.Constants.constants.EXCHANGE;
import static com.luv2code.com.RabbitMQexaample.Constants.constants.ROUTING_KEY;

@RestController
@RequestMapping("/order")
public class OrderPublisher {

    //inject the rabbitTemplate
    @Autowired
    private RabbitTemplate template;

    //one rest endpoint to access order as request
    //publish order to queue
    @PostMapping("/{restaurantName}")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {

        order.setOrderId(UUID.randomUUID().toString());
        //request will go to restaurant service
        //request will also go to Payment service

        OrderStatus orderStatus = new OrderStatus(order, "PROGRESS", "order places Successfully in " + restaurantName);

        //publish message to Queue
        template.convertAndSend(EXCHANGE, ROUTING_KEY, orderStatus);

        return "Success !!";
    }

}
