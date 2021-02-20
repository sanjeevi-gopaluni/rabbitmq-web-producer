package com.devdairy.rabbitmq.webdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RabbitMQDirectConfig {

    @Bean
    @Primary
    Queue logsQueue() {
        return new Queue("LogsQueue", false);
    }

    @Bean
    Queue transactionsQueue() {
        return new Queue("TransactionsQueue", false);
    }

    @Bean
    Queue adminQueue() {
        return new Queue("AdminQueue", false);
    }
    @Bean
    Queue allQueue() {
        return new Queue("allQueue", true);
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topic-exchange");
    }

    @Bean
    Binding logsBinding(Queue logs, TopicExchange exchange) {
        System.out.println("logs Binding");
        return BindingBuilder.bind(logs).to(exchange).with("logs");
    }

    @Bean
    Binding transactionsBinding(Queue tranQueue, TopicExchange exchange) {
        System.out.println("transactions Binding");
        return BindingBuilder.bind(tranQueue).to(exchange).with("transactions");
    }

    @Bean
    Binding adminBinding(Queue admin, TopicExchange exchange) {
        System.out.println("admin Binding");
        return BindingBuilder.bind(admin).to(exchange).with("admin");
    }
    @Bean
    Binding allBinding(Queue all, TopicExchange exchange) {
        System.out.println("all Binding");
        return BindingBuilder.bind(all).to(exchange).with("*");
    }
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
        simpleMessageListenerContainer.setConnectionFactory(connectionFactory);
        return simpleMessageListenerContainer;
    }

    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
