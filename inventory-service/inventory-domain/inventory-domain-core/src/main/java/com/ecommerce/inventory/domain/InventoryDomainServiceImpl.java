package com.ecommerce.inventory.domain;

import com.ecommerce.inventory.domain.entity.*;
import com.ecommerce.inventory.domain.event.*;
import com.ecommerce.inventory.domain.exception.InventoryDomainException;
import com.ecommerce.common.event.publisher.DomainEventPublisher;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import static com.ecommerce.common.DomainConstants.UTC;

public class InventoryDomainServiceImpl implements InventoryDomainService {

    public InventoryCreatedEvent validateAndInitiateInventory(
            Inventory inventory,
            Warehouse warehouse,
            Sku sku,
            DomainEventPublisher<InventoryCreatedEvent> inventoryCreatedEventDomainEventPublisher
    ){
        validateWarehouse(warehouse);
        validateSku(sku);
        // setInventoryInformation(); ??
        inventory.validateInventory();
        inventory.initializeInventory();
        return new InventoryCreatedEvent(
                inventory,
                ZonedDateTime.now(ZoneId.of(UTC)),
                inventoryCreatedEventDomainEventPublisher
        );
    }

    public InventoryAddStockEvent addInventoryStock(
            Inventory inventory,
            Integer quantity,
            DomainEventPublisher<InventoryAddStockEvent> inventoryAddStockEventDomainEventPublisher
    ){
        inventory.addStock(quantity);
        return new InventoryAddStockEvent(
                inventory,
                ZonedDateTime.now(ZoneId.of(UTC)),
                inventoryAddStockEventDomainEventPublisher
        );
    }

    public InventoryReduceStockEvent reduceInventoryStock(
            Inventory inventory,
            Integer quantity,
            DomainEventPublisher<InventoryReduceStockEvent> inventoryReduceStockEventDomainEventPublisher
    ){
        inventory.reduceStock(quantity);
        return new InventoryReduceStockEvent(
                inventory,
                ZonedDateTime.now(ZoneId.of(UTC)),
                inventoryReduceStockEventDomainEventPublisher
        );
    }

    public InventoryRemovedEvent removeInventory(
            Inventory inventory,
            DomainEventPublisher<InventoryRemovedEvent> inventoryRemovedEventDomainEventPublisher
    ){
        inventory.removeStock();
        return new InventoryRemovedEvent(
                inventory,
                ZonedDateTime.now(ZoneId.of(UTC)),
                inventoryRemovedEventDomainEventPublisher
        );
    }

    private void validateWarehouse(Warehouse warehouse){
        if(warehouse.getAddress().getStreet() != null && warehouse.getAddress().getCity() != null && warehouse.getAddress().getPostalCode() != null){
            throw new InventoryDomainException("");
        }
    }

    private void validateSku(Sku sku){

    }

//    public StockMutationCreatedEvent validateAndInitiateStockMutation(
//            Warehouse originWarehouse,
//            Warehouse targetWarehouse,
//            Sku sku, Integer quantity,
//            DomainEventPublisher<StockMutationCreatedEvent> stockMutationCreatedEventDomainEventPublisher){
//        originWarehouse.validateStock();
//        targetWarehouse.validateWarehouse();
//        return new StockMutationCreatedEvent();
//    }

}
