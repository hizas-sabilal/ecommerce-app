package com.ecommerce.inventory.domain.event;

import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.common.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class InventoryCreatedEvent extends InventoryEvent {

    private final DomainEventPublisher<InventoryCreatedEvent> inventoryCreatedEventDomainEventPublisher;

    public InventoryCreatedEvent(
            Inventory inventory,
            ZonedDateTime createdAt,
            DomainEventPublisher<InventoryCreatedEvent> inventoryCreatedEventDomainEventPublisher
    ){
        super(inventory, createdAt);
        this.inventoryCreatedEventDomainEventPublisher = inventoryCreatedEventDomainEventPublisher;
    }

    public void fire() {
        inventoryCreatedEventDomainEventPublisher.publish(this);
    }

}
