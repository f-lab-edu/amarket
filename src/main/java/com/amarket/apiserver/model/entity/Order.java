package com.amarket.apiserver.model.entity;


import com.amarket.apiserver.model.enums.OrderStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "ORDERS")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "order_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime orderTime;

    @Column(name = "order_date")
    private String orderDate; // index

    @Column(name = "seller_id")
    private String sellerId; // 판매자정보 어떻게 관리할지?

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // test

}
