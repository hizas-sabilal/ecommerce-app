package com.ecommerce.inventory.domain.entity;

import com.ecommerce.common.entity.BaseEntity;
import com.ecommerce.common.valueobject.Money;
import com.ecommerce.common.valueobject.SkuId;

public class Sku extends BaseEntity<SkuId> {

    private String name;
    private Money price;

    public Sku(SkuId skuId, String name, Money price) {
        super.setId(skuId);
        this.name = name;
        this.price = price;
    }

    public Sku(SkuId skuId) {
        super.setId(skuId);
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

}
