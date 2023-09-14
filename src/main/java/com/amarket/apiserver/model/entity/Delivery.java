package com.amarket.apiserver.model.entity;


import com.amarket.apiserver.model.enums.DeliveryStatus;
import jakarta.persistence.*;

@Table(name = "DELIVERY")
@Entity
public class Delivery {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
