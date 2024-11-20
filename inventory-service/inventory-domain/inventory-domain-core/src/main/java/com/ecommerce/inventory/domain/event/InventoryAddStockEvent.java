package com.ecommerce.inventory.domain.event;

import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.common.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class InventoryAddStockEvent extends InventoryEvent {

    private final DomainEventPublisher<InventoryAddStockEvent> inventoryAddStockEventDomainEventPublisher;

    public InventoryAddStockEvent(
            Inventory inventory,
            ZonedDateTime createdAt,
            DomainEventPublisher<InventoryAddStockEvent> inventoryAddStockEventDomainEventPublisher
    ){
        super(inventory, createdAt);
        this.inventoryAddStockEventDomainEventPublisher = inventoryAddStockEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        inventoryAddStockEventDomainEventPublisher.publish(this);
    }

}
