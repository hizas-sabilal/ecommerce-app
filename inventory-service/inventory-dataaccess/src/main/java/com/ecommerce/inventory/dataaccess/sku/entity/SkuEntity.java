package com.ecommerce.inventory.dataaccess.sku.entity;

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
@Table(name = "skus", schema = "inventory")
@Entity
public class SkuEntity {
    @Id
    private UUID id;

    private String name;
}
