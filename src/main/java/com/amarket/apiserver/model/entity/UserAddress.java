package com.amarket.apiserver.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Table(name = "USER_ADDRESS")
@Entity
@NoArgsConstructor
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

    @Builder
    public UserAddress(String addressName, String fullAddress, String regionAddress, String roadAddress) {
        this.addressName = addressName;
        this.fullAddress = fullAddress;
        this.regionAddress = regionAddress;
        this.roadAddress = roadAddress;
    }

    public void update(UserAddress userAddress) {
        this.addressName = userAddress.getAddressName();
        this.fullAddress = userAddress.getFullAddress();
        this.regionAddress = userAddress.getRegionAddress();
        this.roadAddress = userAddress.getRoadAddress();
    }
}
