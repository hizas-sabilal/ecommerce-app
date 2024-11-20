package com.ecommerce.inventory.domain.dto.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class GetInventoryResponse {
    private final UUID inventoryId;
    private final UUID warehouseId;
    private final UUID SkuId;
    private final Integer quantity;
    private final Integer reserved;
}
