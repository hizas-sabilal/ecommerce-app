package com.ecommerce.inventory.dataaccess.warehouse.entity;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouses", schema = "inventory")
@Entity
public class WarehouseEntity {
    @Id
    private UUID id;

    private String name;
}
