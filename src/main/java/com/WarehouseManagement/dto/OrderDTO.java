package com.WarehouseManagement.dto;

import com.WarehouseManagement.entity.OrderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {

    @JsonProperty("orderNumber")
    private Long orderNumber;
    @JsonProperty("orderStatus")
    private OrderStatus orderStatus;
    @JsonProperty("submittedDate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date submittedDate;
    @JsonProperty("deadlineDate")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date deadlineDate;


}
