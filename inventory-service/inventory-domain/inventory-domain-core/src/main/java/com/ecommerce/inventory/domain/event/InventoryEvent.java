package com.ecommerce.inventory.domain.event;

import com.ecommerce.common.event.DomainEvent;
import com.ecommerce.inventory.domain.entity.Inventory;

import java.time.ZonedDateTime;

public abstract class InventoryEvent implements DomainEvent<Inventory> {

    private final Inventory inventory;
    private final ZonedDateTime createdAt;

    public InventoryEvent(Inventory inventory, ZonedDateTime createdAt){
        this.inventory = inventory;
        this.createdAt = createdAt;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
