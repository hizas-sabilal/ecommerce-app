package com.ecommerce.inventory.domain.ports.output.repository;

import com.ecommerce.inventory.domain.entity.Warehouse;

import java.util.Optional;
import java.util.UUID;

public interface WarehouseRepository {
    Optional<Warehouse> findWarehouse(UUID warehouseId);
}
