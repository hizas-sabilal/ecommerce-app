package com.ecommerce.inventory.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateInventoryCommand {
    private final UUID warehouseId;
    private final UUID SkuId;
    private final Integer quantity;
}
