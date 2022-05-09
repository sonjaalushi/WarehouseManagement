package com.WarehouseManagement.controller;

import com.WarehouseManagement.dto.OrderDTO;
import com.WarehouseManagement.entity.InventoryItems;
import com.WarehouseManagement.entity.Orders;
import com.WarehouseManagement.entity.Trucks;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ManagerController {

    public ResponseEntity<InventoryItems> createItem(@RequestBody InventoryItems items);


    public ResponseEntity<InventoryItems> updateItemById(@RequestBody InventoryItems items, @PathVariable Long id);

    public ResponseEntity<List<InventoryItems>> getItems();

    public ResponseEntity<String> deleteItemById(@PathVariable Long id);


    public ResponseEntity<Trucks> createTruck(@RequestBody Trucks trucks);


    public ResponseEntity<Trucks> updateTrucById(@RequestBody Trucks trucks, @PathVariable Long id);


    public ResponseEntity<List<Trucks>> getTrucks();

    public ResponseEntity<String> deleteTruckById(@PathVariable Long id);


    public ResponseEntity<List<OrderDTO>> getAll(@PathVariable("orderStatus") Integer orderStatus);

    public ResponseEntity<Orders> getDetailedOrder(@PathVariable Long orderId);

    public ResponseEntity<Orders> submitOrder(@PathVariable("orderId") Long orderId, @RequestBody Orders orders);

//    public ResponseEntity<Delivery> scheduleDelivery(@PathVariable("userId") Long userId, @RequestBody Delivery delivery);
}
