package com.amarket.apiserver.model.entity;

import jakarta.persistence.*;

@Table(name = "REVIEW")
@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "content")
    private String content;

    @Column(name = "score")
    private Integer score;
}
