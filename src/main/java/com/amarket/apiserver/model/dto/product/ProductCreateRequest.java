package com.amarket.apiserver.model.dto.product;

import com.amarket.apiserver.model.entity.Product;
import com.amarket.apiserver.model.entity.Seller;
import lombok.Data;

@Data
public class ProductCreateRequest {
    private String name;
    private Integer price;
    private Integer stockQuantity;
    private String description;
    private Long postId;
    private String sellerId;
    private String category1 ;
    private String category2;
    private String category3;

    public static Product toEntity(ProductCreateRequest dto) {
        System.out.println("toEntity dto.getSellerId() : " + dto.getSellerId());

        Seller seller = new Seller(dto.getSellerId());
        return Product.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .description(dto.getDescription())
                .postId(dto.getPostId())
                .seller(seller)
                .category1(dto.getCategory1())
                .category2(dto.getCategory2())
                .category3(dto.getCategory3())
            .build();
    }
}
