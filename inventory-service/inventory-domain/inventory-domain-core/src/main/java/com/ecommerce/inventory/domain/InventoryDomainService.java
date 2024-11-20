package com.ecommerce.inventory.domain;

import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.inventory.domain.entity.Sku;
import com.ecommerce.inventory.domain.entity.Warehouse;
import com.ecommerce.inventory.domain.event.*;
import com.ecommerce.common.event.publisher.DomainEventPublisher;

public interface InventoryDomainService {

    public InventoryCreatedEvent validateAndInitiateInventory(
            Inventory inventory,
            Warehouse warehouse,
            Sku sku,
            DomainEventPublisher<InventoryCreatedEvent> inventoryAddStockEventDomainEventPublisher
    );

    public InventoryAddStockEvent addInventoryStock(
            Inventory inventory,
            Integer quantity,
            DomainEventPublisher<InventoryAddStockEvent> inventoryAddStockEventDomainEventPublisher
    );

    public InventoryReduceStockEvent reduceInventoryStock(
            Inventory inventory,
            Integer quantity,
            DomainEventPublisher<InventoryReduceStockEvent> inventoryAddStockEventDomainEventPublisher
    );

    public InventoryRemovedEvent removeInventory(
            Inventory inventory,
            DomainEventPublisher<InventoryRemovedEvent> inventoryAddStockEventDomainEventPublisher
    );

}
