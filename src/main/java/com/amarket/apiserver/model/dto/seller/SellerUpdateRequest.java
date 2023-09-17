package com.amarket.apiserver.model.dto.seller;

import com.amarket.apiserver.model.entity.Seller;
import lombok.Data;

@Data
public class SellerUpdateRequest {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String bizNumber;
    private String bizName;
    private String bizAddress;
    private String bizTel;

    public Seller toEntity() {
        return Seller.builder()
                .name(this.name)
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .bizNumber(this.bizNumber)
                .bizName(this.bizName)
                .bizAddress(this.bizAddress)
                .bizTel(this.bizTel)
            .build();
    }
}
