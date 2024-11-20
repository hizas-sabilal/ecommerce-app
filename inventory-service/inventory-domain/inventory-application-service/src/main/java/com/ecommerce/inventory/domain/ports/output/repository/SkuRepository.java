package com.ecommerce.inventory.domain.ports.output.repository;

import com.ecommerce.inventory.domain.entity.Sku;

import java.util.Optional;
import java.util.UUID;

public interface SkuRepository {
    Optional<Sku> findSku(UUID skuId);
}
