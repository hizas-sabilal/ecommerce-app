package com.ecommerce.inventory.domain.event;

import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.common.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class InventoryReduceStockEvent extends InventoryEvent {

    private final DomainEventPublisher<InventoryReduceStockEvent> inventoryReduceEventDomainEventPublisher;

    public InventoryReduceStockEvent(
            Inventory inventory,
            ZonedDateTime createdAt,
            DomainEventPublisher<InventoryReduceStockEvent> inventoryReduceEventDomainEventPublisher
    ){
        super(inventory, createdAt);
        this.inventoryReduceEventDomainEventPublisher = inventoryReduceEventDomainEventPublisher;
    }

    public void fire() {
        inventoryReduceEventDomainEventPublisher.publish(this);
    }

}
