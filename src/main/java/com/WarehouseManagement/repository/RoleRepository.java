package com.WarehouseManagement.repository;

import com.WarehouseManagement.entity.Role;
import com.WarehouseManagement.entity.RoleEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnums name);
}
