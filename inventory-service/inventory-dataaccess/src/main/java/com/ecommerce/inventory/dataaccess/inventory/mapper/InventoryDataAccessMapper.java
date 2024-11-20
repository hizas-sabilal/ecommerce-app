package com.ecommerce.inventory.dataaccess.inventory.mapper;

import com.ecommerce.inventory.dataaccess.inventory.entity.InventoryEntity;
import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.common.valueobject.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

import static com.ecommerce.inventory.domain.entity.Inventory.FAILURE_MESSAGE_DELIMITER;

@Component
public class InventoryDataAccessMapper {

    public InventoryEntity inventoryToInventoryEntity(Inventory inventory) {
        InventoryEntity inventoryEntity = InventoryEntity.builder()
                .id(inventory.getId().getValue())
                .warehouseId(inventory.getWarehouseId().getValue())
                .skuId(inventory.getSkuId().getValue())
                .quantity(inventory.getQuantity())
                .reserved(inventory.getReserved())
                .failureMessages(inventory.getFailureMessages() != null ?
                        String.join(FAILURE_MESSAGE_DELIMITER, inventory.getFailureMessages()) : "")
                .build();
        return inventoryEntity;
    }

    public Inventory inventoryEntityToInventory(InventoryEntity inventoryEntity) {
        return Inventory.builder()
                .inventoryId(new InventoryId(inventoryEntity.getId()))
                .warehouseId(new WarehouseId(inventoryEntity.getWarehouseId()))
                .skuId(new SkuId(inventoryEntity.getSkuId()))
                .quantity(inventoryEntity.getQuantity())
                .reserved(inventoryEntity.getReserved())
                .failureMessages(inventoryEntity.getFailureMessages().isEmpty() ? new ArrayList<>() :
                        new ArrayList<>(Arrays.asList(inventoryEntity.getFailureMessages()
                                .split(FAILURE_MESSAGE_DELIMITER))))
                .build();
    }

}
