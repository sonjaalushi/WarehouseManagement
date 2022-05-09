package com.WarehouseManagement.service;

import com.WarehouseManagement.entity.InventoryItems;
import com.WarehouseManagement.entity.Trucks;
import com.WarehouseManagement.repository.ItemRepository;
import com.WarehouseManagement.repository.TruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    TruckRepository truckRepository;

    @Override
    public InventoryItems createItem(InventoryItems items) {
        return itemRepository.save(items);
    }

    @Override
    public InventoryItems updateItemById(InventoryItems items, Long id) {
        return itemRepository.save(items);
    }

    @Override
    public List<InventoryItems> getItems() {
        return itemRepository.findAll();
    }

    @Override
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Trucks createTruck(Trucks trucks) {
        return truckRepository.save(trucks);
    }

    @Override
    public Trucks updateTrucById(Trucks trucks, Long id) {
        return truckRepository.save(trucks);
    }

    @Override
    public List<Trucks> getTrucks() {
        return truckRepository.findAll();
    }

    @Override
    public void deleteTruckById(Long id) {
        truckRepository.deleteById(id);
    }
}
