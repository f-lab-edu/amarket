package com.amarket.apiserver.model.dto.useraddress;

import com.amarket.apiserver.model.entity.User;
import com.amarket.apiserver.model.entity.UserAddress;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
public class UserAddressUpdateRequest {
    private String addressName;
    private String fullAddress;
    private String regionAddress;
    private String roadAddress;

    @Builder
    public UserAddressUpdateRequest(String addressName, String fullAddress, String regionAddress, String roadAddress) {
        this.addressName = addressName;
        this.fullAddress = fullAddress;
        this.regionAddress = regionAddress;
        this.roadAddress = roadAddress;
    }

    public static UserAddress toEntity(UserAddressUpdateRequest reqDto) {
        return UserAddress.builder()
                .addressName(reqDto.getAddressName())
                .fullAddress(reqDto.getFullAddress())
                .regionAddress(reqDto.getRegionAddress())
                .roadAddress(reqDto.getRoadAddress())
                .build();
    }
}
