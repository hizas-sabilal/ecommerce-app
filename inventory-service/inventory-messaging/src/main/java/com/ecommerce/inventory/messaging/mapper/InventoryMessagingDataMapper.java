package com.ecommerce.inventory.messaging.mapper;
//
//import com.ecommerce.kafka.inventory.avro.model.*;
//import com.ecommerce.inventory.domain.dto.message.OrderResponse;
//import com.ecommerce.inventory.domain.dto.message.SellerApprovalResponse;
//import com.ecommerce.inventory.domain.entity.Inventory;
//import com.ecommerce.inventory.domain.event.InventoryRemovedEvent;
//import com.ecommerce.inventory.domain.event.InventoryCreatedEvent;
//import com.ecommerce.inventory.domain.event.InventoryPaidEvent;
import com.ecommerce.inventory.domain.entity.Inventory;
import com.ecommerce.inventory.domain.event.InventoryCreatedEvent;
import com.ecommerce.kafka.order.avro.model.OrderRequestAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

//
//import java.util.UUID;
//import java.util.stream.Collectors;
//
@Component
public class InventoryMessagingDataMapper {

    public OrderRequestAvroModel inventoryCreatedEventToOrderRequestAvroModel(InventoryCreatedEvent inventoryCreatedEvent) {
        Inventory inventory = inventoryCreatedEvent.getInventory();
        return OrderRequestAvroModel.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setSagaId("")
                .setInventoryId(inventory.getId().getValue().toString())
                .setWarehouseId(inventory.getWarehouseId().getValue().toString())
                .setSkuId(inventory.getSkuId().getValue().toString())
                .setCreatedAt(inventoryCreatedEvent.getCreatedAt().toInstant())
                .build();
    }
//
//    public OrderRequestAvroModel inventoryCancelledEventToOrderRequestAvroModel(InventoryCancelledEvent inventoryCancelledEvent) {
//        Inventory inventory = inventoryCancelledEvent.getInventory();
//        return OrderRequestAvroModel.newBuilder()
//                .setId(UUID.randomUUID().toString())
//                .setSagaId("")
//                .setCustomerId(inventory.getCustomerId().getValue().toString())
//                .setInventoryId(inventory.getId().getValue().toString())
//                .setPrice(inventory.getPrice().getAmount())
//                .setCreatedAt(inventoryCancelledEvent.getCreatedAt().toInstant())
//                .setOrderInventoryStatus(OrderInventoryStatus.CANCELLED)
//                .build();
//    }
//
//    public SellerApprovalRequestAvroModel
//    inventoryPaidEventToSellerApprovalRequestAvroModel(InventoryPaidEvent inventoryPaidEvent) {
//        Inventory inventory = inventoryPaidEvent.getInventory();
//        return SellerApprovalRequestAvroModel.newBuilder()
//                .setId(UUID.randomUUID().toString())
//                .setSagaId("")
//                .setInventoryId(inventory.getId().getValue().toString())
//                .setSellerId(inventory.getSellerId().getValue().toString())
//                .setInventoryId(inventory.getId().getValue().toString())
//                .setSellerInventoryStatus(com.ecommerce.kafka.inventory.avro.model.SellerInventoryStatus
//                        .valueOf(inventory.getInventoryStatus().name()))
//                .setProducts(inventory.getItems().stream().map(inventoryItem ->
//                        com.ecommerce.kafka.inventory.avro.model.Product.newBuilder()
//                                .setId(inventoryItem.getProduct().getId().getValue().toString())
//                                .setQuantity(inventoryItem.getQuantity())
//                                .build()).collect(Collectors.toList()))
//                .setPrice(inventory.getPrice().getAmount())
//                .setCreatedAt(inventoryPaidEvent.getCreatedAt().toInstant())
//                .setSellerInventoryStatus(SellerInventoryStatus.PAID)
//                .build();
//    }
//
//    public OrderResponse orderResponseAvroModelToOrderResponse(OrderResponseAvroModel
//                                                                             orderResponseAvroModel) {
//        return OrderResponse.builder()
//                .id(orderResponseAvroModel.getId())
//                .sagaId(orderResponseAvroModel.getSagaId())
//                .orderId(orderResponseAvroModel.getOrderId())
//                .customerId(orderResponseAvroModel.getCustomerId())
//                .inventoryId(orderResponseAvroModel.getInventoryId())
//                .price(orderResponseAvroModel.getPrice())
//                .createdAt(orderResponseAvroModel.getCreatedAt())
//                .orderStatus(com.ecommerce.domain.valueobject.OrderStatus.valueOf(
//                        orderResponseAvroModel.getOrderStatus().name()))
//                .failureMessage(orderResponseAvroModel.getFailureMessages())
//                .build();
//    }
//
//    public SellerApprovalResponse
//    approvalResponseAvroModelToApprovalResponse(SellerApprovalResponseAvroModel
//                                                        sellerApprovalResponseAvroModel) {
//        return SellerApprovalResponse.builder()
//                .id(sellerApprovalResponseAvroModel.getId())
//                .sagaId(sellerApprovalResponseAvroModel.getSagaId())
//                .sellerId(sellerApprovalResponseAvroModel.getSellerId())
//                .inventoryId(sellerApprovalResponseAvroModel.getInventoryId())
//                .createdAt(sellerApprovalResponseAvroModel.getCreatedAt())
//                .inventoryApprovalStatus(com.ecommerce.domain.valueobject.InventoryApprovalStatus.valueOf(
//                        sellerApprovalResponseAvroModel.getInventoryApprovalStatus().name()))
//                .failureMessage(sellerApprovalResponseAvroModel.getFailureMessages())
//                .build();
//    }
}