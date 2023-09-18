package com.amarket.apiserver.model.dto.seller;

import com.amarket.apiserver.model.entity.Seller;
import lombok.Data;

@Data
public class SellerCreateRequest { //
    private String id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private String bizNumber;
    private String bizName;
    private String bizAddress;
    private String bizTel;

    public Seller toEntity(SellerCreateRequest dto) {
        return Seller.builder()
                .id(dto.getId())
                .password(dto.getPassword())
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.phoneNumber)
                .bizNumber(dto.bizNumber)
                .bizName(dto.bizName)
                .bizAddress(dto.bizAddress)
                .bizTel(dto.bizTel)
                .build();
    }


}
