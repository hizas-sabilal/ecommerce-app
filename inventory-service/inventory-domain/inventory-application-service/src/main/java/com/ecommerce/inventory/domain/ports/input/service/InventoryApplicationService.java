package com.ecommerce.inventory.domain.ports.input.service;

import com.ecommerce.inventory.domain.dto.create.CreateInventoryCommand;
import com.ecommerce.inventory.domain.dto.create.CreateInventoryResponse;

import jakarta.validation.Valid;

public interface InventoryApplicationService {

    CreateInventoryResponse createInventory(@Valid CreateInventoryCommand createInventoryCommand);

}
