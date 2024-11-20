package com.ecommerce.inventory.domain.valueobject;

import com.ecommerce.common.valueobject.BaseId;

import java.util.UUID;

public class StockMutationId extends BaseId<UUID> {

    public StockMutationId(UUID value){
        super(value);
    }

}
