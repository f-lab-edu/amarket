package com.amarket.apiserver.model.dto.user;

import com.amarket.apiserver.model.entity.User;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private String email;
    private String phoneNumber;

    public User toEntity() {
        return User.builder()
                .email(this.email)
                .phoneNumber(this.phoneNumber)
                .build();
    }
}


