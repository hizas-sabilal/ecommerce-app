package com.ecommerce.inventory.domain.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "inventory-service")
public class InventoryServiceConfigData {
    private String orderRequestTopicName;
    private String orderResponseTopicName;
    private String warehouseRequestTopicName;
    private String warehouseResponseTopicName;
}