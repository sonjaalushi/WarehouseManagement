package com.WarehouseManagement.controller;


import com.WarehouseManagement.entity.OrderDetails;
import com.WarehouseManagement.entity.Orders;
import com.WarehouseManagement.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserController {

    public ResponseEntity<User> createOrder(@RequestBody Orders order, @PathVariable Long userId);

    public ResponseEntity<List<Orders>> getAllOrders(@PathVariable Long userId);

    public ResponseEntity<Orders> updateOrder(@PathVariable("userId") Long userId, @PathVariable("orderId") Long orderId, @RequestBody OrderDetails orderDetails);

    public ResponseEntity<String> deleteItemById(@PathVariable("orderId") Long orderId, @PathVariable("id") Long id);

    public ResponseEntity<OrderDetails> updateItemQuantity(@PathVariable("orderId") Long orderId, @PathVariable("itemId") Long itemId, @RequestBody OrderDetails orderDetails);

    public ResponseEntity<String> deleteItemById(@PathVariable("orderId") Long orderId);

    public ResponseEntity<Orders> submitOrder(@PathVariable("orderId") Long orderId);

    public ResponseEntity<List<Orders>> submitOrder(@PathVariable Long userId, @PathVariable("orderStatus") Integer orderStatus);

}