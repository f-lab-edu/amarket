package com.amarket.apiserver.model.dto;

import com.amarket.apiserver.model.entity.Seller;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class SellerResDto {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String bizNumber;
    private String bizName;
    private String bizAddress;
    private String bizTel;

    public static SellerResDto fromEntity(Seller seller) {
        SellerResDto dto = new SellerResDto();
        dto.setId(seller.getId());
        dto.setName(seller.getName());
        dto.setEmail(seller.getEmail());
        dto.setPhoneNumber(seller.getPhoneNumber());
        dto.setBizNumber(seller.getBizNumber());
        dto.setBizName(seller.getBizName());
        dto.setBizAddress(seller.getBizAddress());
        dto.setBizTel(seller.getBizTel());
        return dto;
    }
}
