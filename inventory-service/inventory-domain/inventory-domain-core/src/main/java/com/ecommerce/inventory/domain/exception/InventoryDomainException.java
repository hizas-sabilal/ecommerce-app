package com.ecommerce.inventory.domain.exception;

import com.ecommerce.common.exception.DomainException;

public class InventoryDomainException extends DomainException {

    public InventoryDomainException(String message){
        super(message);
    }

    public InventoryDomainException(String message, Throwable cause){
        super(message, cause);
    }

}
