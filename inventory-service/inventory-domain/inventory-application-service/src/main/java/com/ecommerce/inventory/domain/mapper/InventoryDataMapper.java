package com.ecommerce.inventory.domain.mapper;

import com.ecommerce.inventory.domain.dto.create.CreateInventoryCommand;
import com.ecommerce.inventory.domain.dto.create.CreateInventoryResponse;
import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.common.valueobject.*;
import org.springframework.stereotype.Component;

@Component
public class InventoryDataMapper {

    public Inventory createInventoryCommandToInventory(CreateInventoryCommand createInventoryCommand){
        return Inventory.builder()
                .warehouseId(new WarehouseId(createInventoryCommand.getWarehouseId()))
                .skuId(new SkuId(createInventoryCommand.getSkuId()))
                .quantity(createInventoryCommand.getQuantity())
                .reserved(0)
                .build();
    }

    public CreateInventoryResponse inventoryToCreateInventoryResponse(Inventory inventory, String message){
        return CreateInventoryResponse.builder()
                .inventoryId(inventory.getId().getValue())
                .build();
    }

}
