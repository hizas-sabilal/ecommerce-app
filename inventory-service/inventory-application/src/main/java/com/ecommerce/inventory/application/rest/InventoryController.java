package com.ecommerce.inventory.application.rest;

import com.ecommerce.inventory.domain.dto.create.CreateInventoryCommand;
import com.ecommerce.inventory.domain.dto.create.CreateInventoryResponse;
import com.ecommerce.inventory.domain.dto.get.GetInventoryResponse;
import com.ecommerce.inventory.domain.ports.input.service.InventoryApplicationService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/inventories", produces = "application/vnd.api.v1+json")
public class InventoryController {

    private final InventoryApplicationService inventoryApplicationService;

    public InventoryController(InventoryApplicationService inventoryApplicationService){
        this.inventoryApplicationService = inventoryApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateInventoryResponse> createInventory(@RequestBody CreateInventoryCommand createInventoryCommand){
        log.info("Creating inventory for SKU: {} at warehouse: {}", createInventoryCommand.getSkuId(), createInventoryCommand.getWarehouseId());
        CreateInventoryResponse createInventoryResponse = inventoryApplicationService.createInventory(createInventoryCommand);
        log.info("Inventory created with id: {}", createInventoryResponse.getInventoryId());
        return ResponseEntity.ok(createInventoryResponse);
    }

    @GetMapping("/{warehouseId}")
    public ResponseEntity<GetInventoryResponse> getInventoryResponseByWarehouseId(@PathVariable UUID warehouseId) {
//        GetInventoryResponse getInventoryResponse =
//                inventoryApplicationService.(TrackOrderQuery.builder().orderTrackingId(trackingId).build());
//        log.info("Returning order status with tracking id: {}", trackOrderResponse.getOrderTrackingId());
//        return  ResponseEntity.ok(trackOrderResponse);
        System.out.println("test");
        return null;
    }

}
