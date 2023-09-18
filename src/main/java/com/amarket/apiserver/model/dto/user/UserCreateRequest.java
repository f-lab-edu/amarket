package com.amarket.apiserver.model.dto.user;

import com.amarket.apiserver.model.entity.User;
import lombok.Data;


@Data
public class UserCreateRequest {
    private String id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;

    public static User toEntity(UserCreateRequest req) {
        return User.builder()
                .id(req.getId())
                .password(req.getPassword())
                .name(req.getName())
                .email(req.getEmail())
                .phoneNumber(req.getPhoneNumber())
                .build();
    }
}
