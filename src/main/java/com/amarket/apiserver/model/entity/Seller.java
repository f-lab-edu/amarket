package com.amarket.apiserver.model.entity;


import lombok.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "SELLER")
@ToString
@Getter
@Entity
@NoArgsConstructor
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

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "biz_number")
    private String bizNumber;

    @Column(name = "biz_name")
    private String bizName;

    @Column(name = "biz_addr")
    private String bizAddress;

    @Column(name = "biz_tel")
    private String bizTel;

    public Seller(String sellerId) {
        this.id = id;
    }

    @Builder
    public Seller(String id, String name, String password, String email, String phoneNumber, String bizNumber
            , String bizName, String bizAddress, String bizTel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bizNumber = bizNumber;
        this.bizName = bizName;
        this.bizAddress = bizAddress;
        this.bizTel = bizTel;
    }

    public void update(Seller seller) {
        this.name = seller.getName();
        this.email = seller.getEmail();
        this.phoneNumber = seller.getPhoneNumber();
        this.bizNumber = seller.getBizNumber();
        this.bizName = seller.getBizName();
        this.bizAddress = seller.getBizAddress();
        this.bizTel = seller.getBizTel();
    }
}
