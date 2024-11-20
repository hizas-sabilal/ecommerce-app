package com.ecommerce.inventory.domain.entity;

import com.ecommerce.common.entity.AggregateRoot;
import com.ecommerce.common.valueobject.*;
import com.ecommerce.inventory.domain.exception.InventoryDomainException;

import java.util.List;
import java.util.UUID;

public class Inventory extends AggregateRoot<InventoryId> {

    private final WarehouseId warehouseId;
    private final SkuId skuId;

    private Integer quantity;
    private Integer reserved;

    private List<String> failureMessages;
    public static final String FAILURE_MESSAGE_DELIMITER = ",";

    public void initializeInventory(){
        setId(new InventoryId(UUID.randomUUID()));
    }

    public void validateInventory(){
        validateInitialStock();
    }

    public void addStock(Integer quantity){
        this.quantity += quantity;
    }

    public void reduceStock(Integer quantity){
        this.quantity -= quantity;
    }

    public void reserveStock(Integer quantity){
        this.reserved += quantity;
    }

    public void releaseStock(Integer quantity){
        this.reserved -= quantity;
    }

    public void removeStock(){
        this.quantity = 0;
    }

    private void updateFailureMessages(List<String> failureMessages) {
        if (this.failureMessages != null && failureMessages != null) {
            this.failureMessages.addAll(failureMessages.stream().filter(message -> !message.isEmpty()).toList());
        }
        if (this.failureMessages == null) {
            this.failureMessages = failureMessages;
        }
    }

    private void validateInitialStock(){
        if(getId() != null || quantity != null || reserved != null){
            throw new InventoryDomainException("Stock is not in correct state for initialization!");
        }
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public SkuId getSkuId() {
        return skuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getReserved() {
        return reserved;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }

    private Inventory(Builder builder){
        super.setId(builder.inventoryId);
        warehouseId = builder.warehouseId;
        skuId = builder.skuId;
        quantity = builder.quantity;
        reserved = builder.reserved;
        failureMessages = builder.failureMessages;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static final class Builder {
        private InventoryId inventoryId;
        private WarehouseId warehouseId;
        private SkuId skuId;
        private Integer quantity;
        private Integer reserved;
        private List<String> failureMessages;

        private Builder(){}

        public Builder inventoryId(InventoryId val){
            inventoryId = val;
            return this;
        }

        public Builder warehouseId(WarehouseId val){
            warehouseId = val;
            return this;
        }

        public Builder skuId(SkuId val){
            skuId = val;
            return this;
        }

        public Builder quantity(Integer val){
            quantity = val;
            return this;
        }

        public Builder reserved(Integer val){
            reserved = val;
            return this;
        }

        public Builder failureMessages(List<String> val) {
            failureMessages = val;
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }

    }
}
