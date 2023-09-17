package com.amarket.apiserver.model.dto.product;

import com.amarket.apiserver.model.entity.Product;
import com.amarket.apiserver.model.entity.Seller;
import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String description;
    private Long postId;
    private Seller seller;
    private Long sellerId;
    private String category1 ;
    private String category2;
    private String category3;

    public static Product toEntity(ProductUpdateRequest dto) {
        return Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .description(dto.getDescription())
                .postId(dto.getPostId())
                .seller(dto.getSeller())
                .category1(dto.getCategory1())
                .category2(dto.getCategory2())
                .category3(dto.getCategory3())
                .build();
    }
}
