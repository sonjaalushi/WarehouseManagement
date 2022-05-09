package com.WarehouseManagement.repository;

import com.WarehouseManagement.entity.InventoryItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<InventoryItems, Long> {
    public InventoryItems getInventoryItemsByItemName(String name);
}
