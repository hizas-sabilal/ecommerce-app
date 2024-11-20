package com.ecommerce.inventory.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = { "com.ecommerce.inventory.dataaccess", "com.ecommerce.dataaccess" })
@EntityScan(basePackages = { "com.ecommerce.inventory.dataaccess", "com.ecommerce.dataaccess"})
@SpringBootApplication(scanBasePackages = "com.ecommerce")

public class InventoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
}