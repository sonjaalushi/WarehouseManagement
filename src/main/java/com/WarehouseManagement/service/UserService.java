package com.WarehouseManagement.service;


import com.WarehouseManagement.entity.Orders;

import java.util.List;

public interface UserService {
    public Orders createOrder(Orders order);


    public List<Orders> findAll();


}
