package com.github.fabiomqs.productapi.modules.product.rabbitmq;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fabiomqs.productapi.modules.product.dto.ProductStockDTO;
import com.github.fabiomqs.productapi.modules.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductStockListener {


    private final ProductService productService;

    public ProductStockListener(ProductService productService) {
        this.productService = productService;
    }

    @RabbitListener(queues = "${app-config.rabbit.queue.product-stock}")
    public void recieveProductStockMessage(ProductStockDTO product) throws JsonProcessingException {
        log.info("Recieving message with data: {} and TransactionID: {}",
                new ObjectMapper().writeValueAsString(product),
                product.getTransactionid());
        productService.updateProductStock(product);
    }
}
