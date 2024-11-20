package com.ecommerce.inventory.domain.valueobject;

import com.ecommerce.common.valueobject.BaseId;

import java.util.UUID;

public class StockReservationId extends BaseId<UUID> {

    public StockReservationId(UUID value){
        super(value);
    }

}
