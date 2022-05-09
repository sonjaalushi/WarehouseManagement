package com.WarehouseManagement.controller;

import com.WarehouseManagement.dto.OrderDTO;
import com.WarehouseManagement.entity.InventoryItems;
import com.WarehouseManagement.entity.OrderStatus;
import com.WarehouseManagement.entity.Orders;
import com.WarehouseManagement.entity.Trucks;
import com.WarehouseManagement.repository.*;
import com.WarehouseManagement.service.ManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/manager")
@PreAuthorize("hasRole('MANAGER')")
public class ManagerControllerImpl implements ManagerController {

    @Autowired
    ManagerServiceImpl managerService;

    @Autowired
    OrderRepository orderRepository;

    private Logger log = Logger.getLogger(String.valueOf(this.getClass()));


    @Override
    @PostMapping("/createItem")
    public ResponseEntity<InventoryItems> createItem(@RequestBody InventoryItems items) {
        log.info("Creating new Item");
        InventoryItems inventoryItems = managerService.createItem(items);
        return new ResponseEntity<>(inventoryItems, HttpStatus.OK);
    }

    @PostMapping("/updateItemById/{id}")
    @Override
    public ResponseEntity<InventoryItems> updateItemById(@RequestBody InventoryItems items, @PathVariable("id") Long id) {
        log.info("Update Item By Id");
        items.setInventoryItems_id(id);
        InventoryItems inventoryItems = managerService.updateItemById(items, id);
        return new ResponseEntity<>(inventoryItems, HttpStatus.OK);
    }

    @Override
    @GetMapping("/getItems")
    public ResponseEntity<List<InventoryItems>> getItems() {
        log.info("Get all items");
        List<InventoryItems> items = managerService.getItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/deleteItemById/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable Long id) {
        log.info("Delete Item By Id");
        managerService.deleteItemById(id);
        return new ResponseEntity<String>("Item deleted successfully!.", HttpStatus.OK);
    }

    @Override
    @PostMapping("/createTruck")
    public ResponseEntity<Trucks> createTruck(@RequestBody Trucks trucks) {
        Trucks trucks1 = managerService.createTruck(trucks);
        return new ResponseEntity<>(trucks1, HttpStatus.OK);
    }

    @Override
    @PostMapping("/updateTruckById/{id}")
    public ResponseEntity<Trucks> updateTrucById(@RequestBody Trucks trucks, @PathVariable("id") Long id) {
        trucks.setTruck_id(id);
        Trucks trucks1 = managerService.updateTrucById(trucks, id);
        return new ResponseEntity<>(trucks1, HttpStatus.OK);
    }

    @Override
    @GetMapping("/getTrucks")
    public ResponseEntity<List<Trucks>> getTrucks() {
        List<Trucks> trucks = managerService.getTrucks();
        return new ResponseEntity<>(trucks, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/deleteTruckById/{id}")
    public ResponseEntity<String> deleteTruckById(@PathVariable Long id) {
        managerService.deleteTruckById(id);
        return new ResponseEntity<String>("Truck deleted successfully!.", HttpStatus.OK);
    }


    @Override
    @GetMapping(value = "/getAll/{orderStatus}")
    public ResponseEntity<List<OrderDTO>> getAll(@PathVariable("orderStatus") Integer orderStatus) {
        List<Orders> orders = orderRepository.findAll();
        List<OrderDTO> orderDTOList = new ArrayList<>();
        orders = orderRepository.filterByStatus(orderStatus);
        orders.stream().forEach(orders1 -> {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderNumber(orders1.getOrderNumber());
            orderDTO.setOrderStatus(orders1.getOrderStatus());
            orderDTO.setDeadlineDate(orders1.getDeadlineDate());
            orderDTO.setSubmittedDate(orders1.getSubmittedDate());
            orderDTOList.add(orderDTO);


        });

        orderDTOList.sort(Collections.reverseOrder(Comparator.comparing(OrderDTO::getSubmittedDate)));

        return new ResponseEntity<>(orderDTOList, HttpStatus.OK);
    }


    @Override
    @GetMapping("/{orderId}/viewDetailedOrder")
    public ResponseEntity<Orders> getDetailedOrder(@PathVariable Long orderId) {
        Orders orders = orderRepository.getById(orderId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    @Override
    @PostMapping(value = "updateOrderStatus/{orderId}")
    public ResponseEntity<Orders> submitOrder(@PathVariable("orderId") Long orderId, @RequestBody Orders orders) {

        Orders orders1 = orderRepository.findById(orderId).get();
        OrderStatus orderStatus = orders1.getOrderStatus();
        if (orderStatus.equals(OrderStatus.AWAITING_APPROVAL) || orderStatus.equals(OrderStatus.DECLINED)) {
            orders1.setOrderStatus(orders.getOrderStatus());
            orders1.setMessage(orders.getMessage());
            orderRepository.save(orders1);
            return new ResponseEntity<>(orders1, HttpStatus.OK);

        } else return null;


    }

//    @Autowired
//    DeliveryRepo deliveryRepo;
//
//    @Autowired
//    AdminRepository adminRepository;
//
//    @Autowired
//    ItemRepository itemRepository;
//
//    @Autowired
//    OrderDetailsRepo orderDetailsRepo;

//    @Override
//    @PostMapping(value = "/{userId}/scheduleDelivery")
//    public ResponseEntity<Delivery> scheduleDelivery(@PathVariable("userId") Long userId, @RequestBody Delivery delivery) {
//        Orders orders = new Orders();
//        User user = adminRepository.findById(userId).get();
//        delivery.setOrders(user.getOrders());
//        List<Orders> ordersList = user.getOrders();
//        ordersList.stream().forEach(orders1 -> {
//            Integer size = orders1.getOrderDetails().size();
//            Integer sum = 0;
//            sum = sum + size;
//            if (size > 10) {
//                System.out.println("Get another truck because number of items is greater than 10");
//            }
//        });
//        orders.setOrderStatus(OrderStatus.UNDER_DELIVERY);
//        orders.getOrderDetails().stream().forEach(orderDetails -> {
//            Long quantity = orderDetails.getQuantity();
//            InventoryItems inventoryItems = orderDetails.getInventoryItemsList();
//            Long stock = inventoryItems.getQuantity();
//            stock = stock - quantity;
//            inventoryItems.setQuantity(stock);
//
//        });
//
//        delivery = deliveryRepo.save(delivery);
//        return new ResponseEntity<>(delivery, HttpStatus.OK);
//    }

}
