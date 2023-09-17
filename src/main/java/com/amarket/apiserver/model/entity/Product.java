package com.amarket.apiserver.model.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @Column(name = "category_1")
    private String category1 ;

    @Column(name = "category_2")
    private String category2;

    @Column(name = "category_3")
    private String category3;

    @Builder
    public Product(String name, Integer price, Integer stockQuantity, String description, Long postId, Seller seller,
                   String category1, String category2, String category3) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
        this.postId = postId;
        this.seller = seller;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
    }

    public Product() {

    }

    public void update(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
        this.description = product.getDescription();
        this.postId = product.getPostId();
        this.seller = product.getSeller();
        this.category1 = product.getCategory1();
        this.category2 = product.getCategory2();
        this.category3 = product.getCategory3();
    }

}
