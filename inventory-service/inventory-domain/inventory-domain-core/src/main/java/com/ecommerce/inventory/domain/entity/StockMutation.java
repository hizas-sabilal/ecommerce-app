package com.ecommerce.inventory.domain.entity;

import com.ecommerce.common.entity.AggregateRoot;
import com.ecommerce.common.valueobject.*;
import com.ecommerce.inventory.domain.exception.InventoryDomainException;
import com.ecommerce.inventory.domain.valueobject.StockMutationId;
import com.ecommerce.inventory.domain.valueobject.StockMutationStatus;
import com.ecommerce.inventory.domain.valueobject.StockMutationType;

public class StockMutation extends AggregateRoot<StockMutationId> {

    private InventoryId inventoryId;
    private StockMutationType stockMutationType; //Addition, Reduction

    private InventoryId originInventoryId;
    private InventoryId destinationInventoryId;

    private StockMutationStatus stockMutationStatus;
    private Integer quantity;

    void initializeStockMutation(){
        stockMutationStatus = StockMutationStatus.PENDING;
    }

    public void approve(){
        if(stockMutationStatus != StockMutationStatus.PENDING){
            throw new InventoryDomainException("Stock Mutation is not in correct state for receive operation!");
        }
        stockMutationStatus = StockMutationStatus.APPROVED;
    }

    public void receive(){
        if(stockMutationStatus != StockMutationStatus.APPROVED){
            throw new InventoryDomainException("Stock Mutation is not in correct state for receive operation!");
        }
        stockMutationStatus = StockMutationStatus.RECEIVED;
    }

    public void cancel(){
        if(stockMutationStatus != StockMutationStatus.PENDING){
            throw new InventoryDomainException("Stock Mutation is not in correct state for receive operation!");
        }
        stockMutationStatus = StockMutationStatus.CANCELLED;
    }

}
