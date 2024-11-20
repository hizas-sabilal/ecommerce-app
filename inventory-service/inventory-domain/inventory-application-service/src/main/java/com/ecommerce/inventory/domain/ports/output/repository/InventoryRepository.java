package com.ecommerce.inventory.domain.ports.output.repository;

import com.ecommerce.common.valueobject.*;
import com.ecommerce.inventory.domain.entity.Inventory;

import java.util.Optional;

public interface InventoryRepository {

    Inventory save(Inventory inventory);

    Optional<Inventory> findById(InventoryId inventoryId);

}
