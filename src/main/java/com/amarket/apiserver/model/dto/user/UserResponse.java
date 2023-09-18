package com.amarket.apiserver.model.dto.user;


import com.amarket.apiserver.model.entity.User;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    public static UserResponse fromEntity(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        return dto;
    }
}
