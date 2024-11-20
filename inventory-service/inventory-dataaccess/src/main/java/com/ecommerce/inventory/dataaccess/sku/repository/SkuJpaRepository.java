package com.ecommerce.inventory.dataaccess.sku.repository;

import com.ecommerce.inventory.dataaccess.sku.entity.SkuEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SkuJpaRepository extends JpaRepository<SkuEntity, UUID> {
}
