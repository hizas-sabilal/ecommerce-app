package com.ecommerce.inventory.domain.exception;

import com.ecommerce.common.exception.DomainException;

public class InventoryNotFoundException extends DomainException {
    public InventoryNotFoundException(String message) {
        super(message);
    }
    public InventoryNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
