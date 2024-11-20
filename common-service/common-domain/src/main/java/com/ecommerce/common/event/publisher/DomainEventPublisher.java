package com.ecommerce.common.event.publisher;

import com.ecommerce.common.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
