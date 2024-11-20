package com.ecommerce.inventory.dataaccess.warehouse.mapper;

import com.ecommerce.common.valueobject.WarehouseId;
import com.ecommerce.inventory.dataaccess.warehouse.entity.WarehouseEntity;
import com.ecommerce.inventory.domain.entity.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class WarehouseDataAccessMapper {

    public Warehouse warehouseEntityToWarehouse(WarehouseEntity warehouseEntity) {
        return new Warehouse(new WarehouseId(warehouseEntity.getId()));
    }
}
