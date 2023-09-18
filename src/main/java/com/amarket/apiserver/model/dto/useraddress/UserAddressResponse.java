package com.amarket.apiserver.model.dto.useraddress;

import com.amarket.apiserver.model.entity.User;
import com.amarket.apiserver.model.entity.UserAddress;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
public class UserAddressResponse {
    private Long id;
    private String addressName;
    private String fullAddress;
    private String regionAddress;
    private String roadAddress;
    private User user;

    @Builder
    public UserAddressResponse(Long id, String addressName, String fullAddress, String regionAddress, String roadAddress
            , User user) {
        this.id = id;
        this.addressName = addressName;
        this.fullAddress = fullAddress;
        this.regionAddress = regionAddress;
        this.roadAddress = roadAddress;
        this.user = user;
    }

    public static UserAddressResponse fromEntity(UserAddress userAddress) {
        return UserAddressResponse.builder()
                .id(userAddress.getId())
                .addressName(userAddress.getAddressName())
                .fullAddress(userAddress.getFullAddress())
                .regionAddress(userAddress.getRegionAddress())
                .roadAddress(userAddress.getRoadAddress())
                .user(userAddress.getUser())
                .build();
    }
}

