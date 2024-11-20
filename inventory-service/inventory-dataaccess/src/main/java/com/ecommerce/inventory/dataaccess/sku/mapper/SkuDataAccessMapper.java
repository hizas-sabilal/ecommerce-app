package com.ecommerce.inventory.dataaccess.sku.mapper;

import com.ecommerce.common.valueobject.SkuId;
import com.ecommerce.inventory.dataaccess.sku.entity.SkuEntity;
import com.ecommerce.inventory.domain.entity.Sku;
import org.springframework.stereotype.Component;

@Component
public class SkuDataAccessMapper {

    public Sku skuEntityToSku(SkuEntity skuEntity) {
        return new Sku(new SkuId(skuEntity.getId()));
    }
}
