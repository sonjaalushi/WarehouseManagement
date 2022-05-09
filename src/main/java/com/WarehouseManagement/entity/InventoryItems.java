package com.WarehouseManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "inventoryItems")
public class InventoryItems {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inventoryItems_id")
    private Long inventoryItems_id;
    @Column(name = "itemName")
    private String itemName;
    @Column(name = "quantity")
    private Long quantity;
    @Column(name = "price")
    private float price;


    public InventoryItems() {

    }
}
