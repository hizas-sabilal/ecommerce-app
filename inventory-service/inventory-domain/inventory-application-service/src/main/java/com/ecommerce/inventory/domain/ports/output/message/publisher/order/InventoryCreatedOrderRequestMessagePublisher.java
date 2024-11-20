package com.ecommerce.inventory.domain.ports.output.message.publisher.order;

import com.ecommerce.common.event.publisher.DomainEventPublisher;
import com.ecommerce.inventory.domain.event.InventoryCreatedEvent;

public interface InventoryCreatedOrderRequestMessagePublisher extends DomainEventPublisher<InventoryCreatedEvent> {
}
