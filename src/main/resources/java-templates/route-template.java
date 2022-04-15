package com.example.demorabitmqspringintegration;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.transformer.ObjectToStringTransformer;

// dsl
// m1 m2
@Configuration
public class JavaDSLAmqp {
    @Bean
    public IntegrationFlow amqpInbound(ConnectionFactory connectionFactory, RabbitTemplate rabbitTemplate) {
        return IntegrationFlows.from(--FLOW_TEMPLATE--)
                .get();
    }
}
