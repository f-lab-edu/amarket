package com.amarket.apiserver.model.entity;


import com.amarket.apiserver.model.dto.SellerUpdateReqDto;
import lombok.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Table(name = "SELLER")
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Seller {
    @Id
    @Column(name = "seller_id")
    private String id;

    @Column(name = "seller_name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "bizNumber")
    private String bizNumber;

    @Column(name = "bizName")
    private String bizName;

    @Column(name = "bizAddress")
    private String bizAddress;

    @Column(name = "bizTel")
    private String bizTel;

    @OneToMany(mappedBy = "seller") // 맵핑되는 테이블의 필드이름
    private List<Category> productCategories = new ArrayList<>();

    public void update(SellerUpdateReqDto reqDto) {
        this.name = reqDto.getName();
        this.email = reqDto.getEmail();
        this.phoneNumber = reqDto.getPhoneNumber();
        this.bizNumber = reqDto.getBizNumber();
        this.bizName = reqDto.getBizName();
        this.bizAddress = reqDto.getBizAddress();
        this.bizTel = reqDto.getBizTel();
    }
}
