package com.WarehouseManagement.service;


import com.WarehouseManagement.entity.Orders;
import com.WarehouseManagement.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Orders createOrder(Orders order) {
        return orderRepository.save(order);
    }


    @Override
    public List<Orders> findAll() {
        List<Orders> list = orderRepository.findAll();
        return list;
    }





}
