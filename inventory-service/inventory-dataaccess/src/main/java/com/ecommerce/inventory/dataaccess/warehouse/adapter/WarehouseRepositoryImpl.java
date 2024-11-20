package com.ecommerce.inventory.dataaccess.warehouse.adapter;

import com.ecommerce.inventory.dataaccess.warehouse.entity.WarehouseEntity;
import com.ecommerce.inventory.dataaccess.warehouse.repository.WarehouseJpaRepository;
import com.ecommerce.inventory.dataaccess.warehouse.mapper.WarehouseDataAccessMapper;
import com.ecommerce.inventory.domain.entity.Warehouse;
import com.ecommerce.inventory.domain.ports.output.repository.WarehouseRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class WarehouseRepositoryImpl implements WarehouseRepository {

    private final WarehouseJpaRepository warehouseJpaRepository;
    private final WarehouseDataAccessMapper warehouseDataAccessMapper;

    public WarehouseRepositoryImpl(WarehouseJpaRepository warehouseJpaRepository,
                                  WarehouseDataAccessMapper warehouseDataAccessMapper) {
        this.warehouseJpaRepository = warehouseJpaRepository;
        this.warehouseDataAccessMapper = warehouseDataAccessMapper;
    }

    @Override
    public Optional<Warehouse> findWarehouse(UUID warehouseId) {
        return warehouseJpaRepository.findById(warehouseId).map(warehouseDataAccessMapper::warehouseEntityToWarehouse);
    }
}
