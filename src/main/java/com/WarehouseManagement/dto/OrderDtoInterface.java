package com.WarehouseManagement.dto;

import com.WarehouseManagement.entity.OrderStatus;

import java.util.Date;

public interface OrderDtoInterface {


    Long getOrderNumber();

    OrderStatus getOrderStatus();

    Date getSubmittedDate();

    Date getDeadlineDate();
}
