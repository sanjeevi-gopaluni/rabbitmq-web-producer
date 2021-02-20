package com.devdairy.rabbitmq.webdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RabbitMQConfig {
//    @Value("${rabbitmq.queue}")
//    String queueName;
//    @Value("${rabbitmq.exchange}")
//    String exchange;
//    @Value("${rabbitmq.routingkey}")
//    String routingKey;
//
//    @Bean
//    Queue queu() {
//        return new Queue(queueName, false);
//    }
//
////    @Bean
////    DirectExchange exchange() {
////        return new DirectExchange(exchange);
////    }
//
//    @Bean
//    Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(routingKey);
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public AmqpTemplate rabbitMqTemplate(ConnectionFactory con) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(con);
//
//        rabbitTemplate.setMessageConverter(jsonMessageConverter());
//        return rabbitTemplate;
//    }
}
