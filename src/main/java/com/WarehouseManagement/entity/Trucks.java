package com.WarehouseManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "truck")
public class Trucks {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long truck_id;
    @Column(unique = true)
    private Long chassisNumber;
    @Column(unique = true)
    private String licensePlate;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderNumber")
    private Orders orders;

    public Trucks() {

    }
}
