package com.ecommerce.inventory.domain;

import com.ecommerce.inventory.domain.dto.create.CreateInventoryCommand;
import com.ecommerce.inventory.domain.entity.*;
import com.ecommerce.inventory.domain.event.*;
import com.ecommerce.inventory.domain.exception.*;
import com.ecommerce.inventory.domain.mapper.InventoryDataMapper;
import com.ecommerce.inventory.domain.ports.output.message.publisher.order.InventoryCreatedOrderRequestMessagePublisher;
import com.ecommerce.inventory.domain.ports.output.repository.InventoryRepository;
import com.ecommerce.inventory.domain.ports.output.repository.WarehouseRepository;
import com.ecommerce.inventory.domain.ports.output.repository.SkuRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class InventoryCreateHelper {

    private final InventoryDomainService inventoryDomainService;

    private final InventoryRepository inventoryRepository;

    private final WarehouseRepository warehouseRepository;

    private final SkuRepository skuRepository;

    private final InventoryDataMapper inventoryDataMapper;

    private final InventoryCreatedOrderRequestMessagePublisher orderCreatedEventDomainEventPublisher;

    public InventoryCreateHelper(
            InventoryDomainService inventoryDomainService,
            InventoryRepository inventoryRepository,
            WarehouseRepository warehouseRepository,
            SkuRepository skuRepository,
            InventoryDataMapper inventoryDataMapper,
            InventoryCreatedOrderRequestMessagePublisher orderCreatedEventDomainEventPublisher) {
        this.inventoryDomainService = inventoryDomainService;
        this.inventoryRepository = inventoryRepository;
        this.warehouseRepository = warehouseRepository;
        this.skuRepository = skuRepository;
        this.inventoryDataMapper = inventoryDataMapper;
        this.orderCreatedEventDomainEventPublisher = orderCreatedEventDomainEventPublisher;
    }

    @Transactional
    public InventoryCreatedEvent persistInventory(CreateInventoryCommand createInventoryCommand) {
        Warehouse warehouse = checkWarehouse(createInventoryCommand.getWarehouseId());
        Sku sku = checkSku(createInventoryCommand.getSkuId());
        Inventory inventory = inventoryDataMapper.createInventoryCommandToInventory(createInventoryCommand);
        InventoryCreatedEvent inventoryCreatedEvent = inventoryDomainService.validateAndInitiateInventory(inventory, warehouse, sku, orderCreatedEventDomainEventPublisher);
        saveInventory(inventory);
        log.info("Inventory is created with id: {}", inventoryCreatedEvent.getInventory().getId().getValue());
        return inventoryCreatedEvent;
    }

    private Warehouse checkWarehouse(UUID warehouseId) {
        Optional<Warehouse> warehouse = warehouseRepository.findWarehouse(warehouseId);
        if (warehouse.isEmpty()) {
            log.warn("Could not find warehouse with warehouse id: {}", warehouseId);
            throw new InventoryDomainException("Could not find warehouse with warehouse id: " + warehouse);
        }
        return warehouse.get();
    }

    private Sku checkSku(UUID skuId) {
        Optional<Sku> sku = skuRepository.findSku(skuId);
        if (sku.isEmpty()) {
            log.warn("Could not find SKU with SKU id: {}", skuId);
            throw new InventoryDomainException("Could not find SKU with SKU id: " + sku);
        }
        return sku.get();
    }

    private Inventory saveInventory(Inventory inventory) {
        Inventory inventoryResult = inventoryRepository.save(inventory);
        if (inventoryResult == null) {
            log.error("Could not save inventory!");
            throw new InventoryDomainException("Could not save inventory!");
        }
        log.info("Inventory is saved with id: {}", inventoryResult.getId().getValue());
        return inventoryResult;
    }
}
