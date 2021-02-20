package com.devdairy.rabbitmq.webdemo.service;

import com.devdairy.rabbitmq.webdemo.model.Transaction;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Value("${rabbitmq.exchange}")
    private String exchange;
    @Value("${rabbitmq.routingkey}")
    private String routingKey;

    public void send(Transaction transaction) {
        rabbitTemplate.convertAndSend(exchange, routingKey, transaction);
        System.out.println("Send msg=" + transaction);
    }

}
