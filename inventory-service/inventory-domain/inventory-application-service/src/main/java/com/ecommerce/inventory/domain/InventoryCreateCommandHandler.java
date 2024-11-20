package com.ecommerce.inventory.domain;

import com.ecommerce.inventory.domain.dto.create.CreateInventoryCommand;
import com.ecommerce.inventory.domain.dto.create.CreateInventoryResponse;
import com.ecommerce.inventory.domain.event.InventoryCreatedEvent;
import com.ecommerce.inventory.domain.mapper.InventoryDataMapper;
import com.ecommerce.inventory.domain.ports.output.message.publisher.order.InventoryCreatedOrderRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class InventoryCreateCommandHandler {

    private final InventoryCreateHelper inventoryCreateHelper;

    private final InventoryDataMapper inventoryDataMapper;

    private final InventoryCreatedOrderRequestMessagePublisher inventoryCreatedOrderRequestMessagePublisher;

    public InventoryCreateCommandHandler(InventoryCreateHelper inventoryCreateHelper,
                                     InventoryDataMapper inventoryDataMapper,
                                     InventoryCreatedOrderRequestMessagePublisher inventoryCreatedOrderRequestMessagePublisher) {
        this.inventoryCreateHelper = inventoryCreateHelper;
        this.inventoryDataMapper = inventoryDataMapper;
        this.inventoryCreatedOrderRequestMessagePublisher = inventoryCreatedOrderRequestMessagePublisher;
    }

    public CreateInventoryResponse createInventory(CreateInventoryCommand createInventoryCommand) {
        InventoryCreatedEvent inventoryCreatedEvent = inventoryCreateHelper.persistInventory(createInventoryCommand);
        log.info("Inventory is created with id: {}", inventoryCreatedEvent.getInventory().getId().getValue());
        inventoryCreatedOrderRequestMessagePublisher.publish(inventoryCreatedEvent);
        return inventoryDataMapper.inventoryToCreateInventoryResponse(inventoryCreatedEvent.getInventory(),
                "Inventory created successfully");
    }
}
