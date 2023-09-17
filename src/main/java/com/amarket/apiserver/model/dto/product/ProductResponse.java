package com.amarket.apiserver.model.dto.product;

import com.amarket.apiserver.model.entity.Product;
import com.amarket.apiserver.model.entity.Seller;
import lombok.Builder;
import lombok.Data;

@Data
public class ProductResponse {
    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String description;
    private Long postId;
    private Seller seller;
    private String category1 ;
    private String category2;
    private String category3;

    @Builder
    public ProductResponse(String name, Integer price, Integer stockQuantity, String description, Long postId,
                           Seller seller, String category1, String category2, String category3) {
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

    public static ProductResponse fromEntity(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stockQuantity(product.getStockQuantity())
                .description(product.getDescription())
                .postId(product.getPostId())
                .seller(product.getSeller())
                .category1(product.getCategory1())
                .category2(product.getCategory2())
                .category3(product.getCategory3())
            .build();
    }
}

