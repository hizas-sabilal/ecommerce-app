package com.ecommerce.inventory.dataaccess.inventory.entity;

//import com.ecommerce.common.valueobject.*;
import lombok.*;

import jakarta.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inventories")
@Entity
public class InventoryEntity {
    @Id
    private UUID id;
    private UUID warehouseId;
    private UUID skuId;
    private Integer quantity;
    private Integer reserved;
    private String failureMessages;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryEntity that = (InventoryEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
