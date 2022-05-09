package com.WarehouseManagement.service;

import com.WarehouseManagement.entity.InventoryItems;
import com.WarehouseManagement.entity.Trucks;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ManagerService {
    public InventoryItems createItem(@RequestBody InventoryItems items);

    public InventoryItems updateItemById(@RequestBody InventoryItems items, @PathVariable Long id);

    public List<InventoryItems> getItems();

    public void deleteItemById(@PathVariable Long id);

    public Trucks createTruck(@RequestBody Trucks trucks);

    public Trucks updateTrucById(@RequestBody Trucks trucks, @PathVariable Long id);

    public List<Trucks> getTrucks();

    public void deleteTruckById(@PathVariable Long id);
}
