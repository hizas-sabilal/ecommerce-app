package com.ecommerce.inventory.dataaccess.inventory.repository;

import com.ecommerce.inventory.dataaccess.inventory.entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, UUID> {

//    Optional<InventoryEntity> findByTrackingId(UUID trackingId);
}