package com.WarehouseManagement.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "orderTable")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderNumber")
    private Long orderNumber;

    //cascade = CascadeType.ALL , mappedBy = "orderTable"
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date submittedDate;
    private OrderStatus orderStatus;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date deadlineDate;

    private String message;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    public Orders() {

    }

    public Orders(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Orders(Orders orders) {
    }


    public Orders(long l, Date time, OrderStatus created, Date time1, String message) {
    }
}
