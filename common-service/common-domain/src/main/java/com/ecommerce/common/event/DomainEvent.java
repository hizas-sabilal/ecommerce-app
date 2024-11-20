package com.ecommerce.common.event;

public interface DomainEvent<T> {
    void fire();
}
