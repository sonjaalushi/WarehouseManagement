package com.WarehouseManagement.controller;


import com.WarehouseManagement.entity.OrderDetails;
import com.WarehouseManagement.entity.OrderStatus;
import com.WarehouseManagement.entity.Orders;
import com.WarehouseManagement.entity.User;
import com.WarehouseManagement.repository.*;
import com.WarehouseManagement.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@PreAuthorize("hasRole('USER')")
public class UserControllerImpl implements UserController {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserServiceImpl userService;
    @Autowired
    PurchasedItemRepository itemRepository;

    @Autowired
    ItemRepository iRepository;

    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @PostMapping(value = "/byUserId/{userId}/createOrder")


    //create a new order
    @Override
    public ResponseEntity<User> createOrder(@RequestBody Orders order, @PathVariable Long userId) {

        User user = adminRepository.getById(userId);
        List<Orders> orders = user.getOrders();
        order.setOrderStatus(OrderStatus.CREATED);
        orders.add(order);
        user.setOrders(orders);
        order = orderRepository.save(order);
        user = adminRepository.save(user);


        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //getAllOrders
    @Override
    @GetMapping("/{userId}/getAllOrders")
    public ResponseEntity<List<Orders>> getAllOrders(@PathVariable Long userId) {
        User user = adminRepository.getById(userId);
        List<Orders> orders = user.getOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }


    //    =======================================
    @Override
    @PostMapping("/{userId}/updateOrderById/{orderId}")
    public ResponseEntity<Orders> updateOrder(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId, @RequestBody OrderDetails orderDetails) {
        User user = adminRepository.findById(userId).get();
        Orders orders = orderRepository.findById(orderId).get();
        OrderStatus orderStatus = orders.getOrderStatus();

        if (orderStatus.equals(OrderStatus.CREATED) || orderStatus.equals(OrderStatus.DECLINED)) {
            OrderDetails orderDetails1 = orderDetailsRepo.save(orderDetails);
            List<OrderDetails> orderDetailsList1 = orders.getOrderDetails();
            List<OrderDetails> orderDetailsList = orders.getOrderDetails();
            orderDetailsList.add(orderDetails1);
            orders.setOrderDetails(orderDetailsList1);
            Orders orders1 = orderRepository.save(orders);
            user = adminRepository.save(user);
            return new ResponseEntity<>(orders1, HttpStatus.OK);
        } else return null;
    }


    @DeleteMapping("{orderId}/deleteItemById/{id}")
    public ResponseEntity<String> deleteItemById(@PathVariable("orderId") Long orderId, @PathVariable("id") Long id) {
        Orders orders = orderRepository.findById(orderId).get();
        OrderStatus orderStatus = orders.getOrderStatus();
        if (orderStatus.equals(OrderStatus.CREATED) || orderStatus.equals(OrderStatus.DECLINED)) {
            orderDetailsRepo.deleteById(id);
            return new ResponseEntity<String>("Item deleted successfully!.", HttpStatus.OK);
        } else throw new RuntimeException("The item with id given doesn't exist");
    }

    @Override
    @PostMapping(value = "order/{orderId}/update/item/{itemId}")
    public ResponseEntity<OrderDetails> updateItemQuantity(@PathVariable("orderId") Long orderId, @PathVariable("itemId") Long itemId, @RequestBody OrderDetails orderDetails) {

        Orders orders = orderRepository.findById(orderId).get();
        OrderStatus orderStatus = orders.getOrderStatus();
        if (orderStatus.equals(OrderStatus.CREATED) || orderStatus.equals(OrderStatus.DECLINED)) {
            OrderDetails orderDetails1 = orderDetailsRepo.getById(itemId);
            orderDetails1.setQuantity(orderDetails.getQuantity());
            orderDetailsRepo.save(orderDetails);
            orderRepository.save(orders);
            return new ResponseEntity<>(orderDetails, HttpStatus.OK);

        } else return null;


    }

    @Override
    @DeleteMapping("{orderId}/cancelOrder")
    public ResponseEntity<String> deleteItemById(@PathVariable("orderId") Long orderId) {
        Orders orders = orderRepository.findById(orderId).get();
        OrderStatus orderStatus = orders.getOrderStatus();
        if (orderStatus != (OrderStatus.FULFILLED) || orderStatus != (OrderStatus.UNDER_DELIVERY) || orderStatus != (OrderStatus.CANCELED)) {
            orderRepository.deleteById(orderId);
            return new ResponseEntity<String>("Order cancelled successfully!.", HttpStatus.OK);
        } else throw new RuntimeException("The order with id given doesn't exist");
    }

    @Override
    @PostMapping(value = "submitOrder/{orderId}")
    public ResponseEntity<Orders> submitOrder(@PathVariable("orderId") Long orderId) {

        Orders orders1 = orderRepository.findById(orderId).get();
        OrderStatus orderStatus = orders1.getOrderStatus();
        if (orderStatus.equals(OrderStatus.CREATED) || orderStatus.equals(OrderStatus.DECLINED)) {
            orders1.setOrderStatus(OrderStatus.AWAITING_APPROVAL);
            orderRepository.save(orders1);
            return new ResponseEntity<>(orders1, HttpStatus.OK);

        } else return null;


    }

    @Override
    @PostMapping(value = "{userId}/getOrderByStatus/{orderStatus}")
    public ResponseEntity<List<Orders>> submitOrder(@PathVariable Long userId, @PathVariable("orderStatus") Integer orderStatus) {
        User user = adminRepository.findById(userId).get();
        List<Orders> orders = user.getOrders();
        orders = orderRepository.filterByStatus(orderStatus);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

}


