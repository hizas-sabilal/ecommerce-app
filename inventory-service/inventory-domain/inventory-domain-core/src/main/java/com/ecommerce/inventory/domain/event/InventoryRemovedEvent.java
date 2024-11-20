package com.ecommerce.inventory.domain.event;

import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.common.event.publisher.DomainEventPublisher;


import java.time.ZonedDateTime;

public class InventoryRemovedEvent extends InventoryEvent {

    private final DomainEventPublisher<InventoryRemovedEvent> inventoryRemovedEventDomainEventPublisher;

    public InventoryRemovedEvent(
            Inventory inventory,
            ZonedDateTime createdAt,
            DomainEventPublisher<InventoryRemovedEvent> inventoryRemovedEventDomainEventPublisher
    ){
        super(inventory, createdAt);
        this.inventoryRemovedEventDomainEventPublisher = inventoryRemovedEventDomainEventPublisher;
    }

    public void fire() {
        inventoryRemovedEventDomainEventPublisher.publish(this);
    }

}
