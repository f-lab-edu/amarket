package com.amarket.apiserver.model.dto.useraddress;

import com.amarket.apiserver.model.entity.UserAddress;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserAddressCreateRequest {
    private String addressName;
    private String fullAddress;
    private String regionAddress;
    private String roadAddress;
    private String userId;

    public static UserAddress toEntity(UserAddressCreateRequest dto) {
        return UserAddress.builder()
                .addressName(dto.getAddressName())
                .fullAddress(dto.getFullAddress())
                .regionAddress(dto.getRegionAddress())
                .roadAddress(dto.roadAddress)
                .build();
    }
}
