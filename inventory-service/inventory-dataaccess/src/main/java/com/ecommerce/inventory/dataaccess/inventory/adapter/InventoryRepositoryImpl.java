package com.ecommerce.inventory.dataaccess.inventory.adapter;

import com.ecommerce.common.valueobject.InventoryId;
import com.ecommerce.inventory.dataaccess.inventory.mapper.InventoryDataAccessMapper;
import com.ecommerce.inventory.dataaccess.inventory.repository.InventoryJpaRepository;
import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.inventory.domain.ports.output.repository.InventoryRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class InventoryRepositoryImpl implements InventoryRepository {

    private final InventoryJpaRepository inventoryJpaRepository;
    private final InventoryDataAccessMapper inventoryDataAccessMapper;

    public InventoryRepositoryImpl(InventoryJpaRepository inventoryJpaRepository,
                               InventoryDataAccessMapper inventoryDataAccessMapper) {
        this.inventoryJpaRepository = inventoryJpaRepository;
        this.inventoryDataAccessMapper = inventoryDataAccessMapper;
    }

    @Override
    public Inventory save(Inventory inventory) {
        return inventoryDataAccessMapper.inventoryEntityToInventory(inventoryJpaRepository
                .save(inventoryDataAccessMapper.inventoryToInventoryEntity(inventory)));
    }

    @Override
    public Optional<Inventory> findById(InventoryId inventoryId) {
        return inventoryJpaRepository.findById(inventoryId.getValue()).map(inventoryDataAccessMapper::inventoryEntityToInventory);
    }

}
