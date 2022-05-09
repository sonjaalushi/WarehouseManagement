package com.WarehouseManagement.repository;

import com.WarehouseManagement.entity.Trucks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckRepository extends JpaRepository<Trucks, Long> {
}
