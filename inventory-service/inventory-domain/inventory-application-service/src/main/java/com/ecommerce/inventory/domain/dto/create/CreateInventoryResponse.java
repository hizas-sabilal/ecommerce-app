package com.ecommerce.inventory.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateInventoryResponse {
    private final UUID inventoryId;
    private final String message;
}
