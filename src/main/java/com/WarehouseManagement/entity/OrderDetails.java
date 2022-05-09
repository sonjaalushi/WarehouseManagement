package com.WarehouseManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "orderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderDetails_Id;
    private Long quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "orderNumber", referencedColumnName = "orderNumber")
    private Orders order;


    @OneToOne()
    @JoinColumn(name = "inventoryItemId", referencedColumnName = "inventoryItems_id")
    private InventoryItems inventoryItemsList;

    public OrderDetails() {

    }


}
