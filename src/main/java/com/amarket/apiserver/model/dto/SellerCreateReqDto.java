package com.amarket.apiserver.model.dto;

import com.amarket.apiserver.model.entity.Seller;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SellerCreateReqDto {
    private String id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String bizNumber;
    private String bizName;
    private String bizAddress;
    private String bizTel;

    public Seller toEntity() {
        return Seller.builder()
                .id(this.id)
                .password(this.password)
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
