package com.ecommerce.inventory.domain;

import com.ecommerce.inventory.domain.dto.create.CreateInventoryCommand;
import com.ecommerce.inventory.domain.dto.create.CreateInventoryResponse;
import com.ecommerce.inventory.domain.ports.input.service.InventoryApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
class InventoryApplicationServiceImpl implements InventoryApplicationService {

    private final InventoryCreateCommandHandler inventoryCreateCommandHandler;

    InventoryApplicationServiceImpl(InventoryCreateCommandHandler inventoryCreateCommandHandler) {
        this.inventoryCreateCommandHandler = inventoryCreateCommandHandler;
    }

    @Override
    public CreateInventoryResponse createInventory(CreateInventoryCommand createInventoryCommand) {
        return inventoryCreateCommandHandler.createInventory(createInventoryCommand);
    }
}
