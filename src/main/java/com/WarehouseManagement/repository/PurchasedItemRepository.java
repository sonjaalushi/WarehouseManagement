package com.WarehouseManagement.repository;

import com.WarehouseManagement.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchasedItemRepository extends JpaRepository<OrderDetails, Long> {
}
