package com.amarket.apiserver.model.entity;


import jakarta.persistence.*;

@Table(name = "USER_ADDRESS")
@Entity
public class UserAddress {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addr_id")
    private Long id;

    @Column(name = "addr_name")
    private String addressName;

    @Column(name = "full_addr")
    private String fullAddress;

    @Column(name = "region_addr")
    private String regionAddress;

    @Column(name = "road_addr")
    private String roadAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 카테고리 테이블에 생성될 컬럼이름
    private User user;
}
