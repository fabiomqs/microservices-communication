package com.github.fabiomqs.productapi.modules.sales.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fabiomqs.productapi.modules.sales.dto.SalesConfirmationDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SalesConfirmationSender {


    private final RabbitTemplate rabbitTemplate;

    public SalesConfirmationSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${app-config.rabbit.exchange.product}")
    private String productTopicExchange;

    @Value("${app-config.rabbit.routingKey.sales-confirmation}")
    private String salesConfirmationKey;

    public void sendSalesConfirmationMessage(SalesConfirmationDTO message) {
        try {
            log.info("Sending message: {}", new ObjectMapper().writeValueAsString(message));
            rabbitTemplate.convertAndSend(productTopicExchange, salesConfirmationKey, message);
            log.info("Message was sent successfully!");
        } catch (Exception ex) {
            log.error("Error while trying to send sales confirmation message: ", ex);
        }
    }
}
