package com.amarket.apiserver.model.entity;

import jakarta.persistence.*;

@Table(name = "PRODUCT")
@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "price")
    private Integer price;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "description")
    private String description;

    @Column(name = "post_id")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Column(name = "category_1")
    private String category1 ;

    @Column(name = "category_2")
    private String category2;

    @Column(name = "category_3")
    private String category3;

}
