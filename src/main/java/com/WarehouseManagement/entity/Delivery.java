package com.WarehouseManagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long delivery_id;

    Format dateFormat = new SimpleDateFormat("EEEE, dd/MM/yyyy");
    String deliveryDate = dateFormat.format(new Date());


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Orders> orders;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Trucks> trucks;


    public Delivery() {

    }
}
