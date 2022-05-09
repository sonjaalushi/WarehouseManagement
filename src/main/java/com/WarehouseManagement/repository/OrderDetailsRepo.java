package com.WarehouseManagement.repository;

import com.WarehouseManagement.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Long> {
}
