package com.ecommerce.inventory.dataaccess.sku.adapter;

import com.ecommerce.inventory.dataaccess.sku.mapper.SkuDataAccessMapper;
import com.ecommerce.inventory.dataaccess.sku.repository.SkuJpaRepository;
import com.ecommerce.inventory.domain.entity.Sku;
import com.ecommerce.inventory.domain.ports.output.repository.SkuRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class SkuRepositoryImpl implements SkuRepository {

    private final SkuJpaRepository skuJpaRepository;
    private final SkuDataAccessMapper skuDataAccessMapper;

    public SkuRepositoryImpl(SkuJpaRepository skuJpaRepository,
                                   SkuDataAccessMapper skuDataAccessMapper) {
        this.skuJpaRepository = skuJpaRepository;
        this.skuDataAccessMapper = skuDataAccessMapper;
    }

    @Override
    public Optional<Sku> findSku(UUID skuId) {
        return skuJpaRepository.findById(skuId).map(skuDataAccessMapper::skuEntityToSku);
    }
}
