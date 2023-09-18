package com.amarket.apiserver.service;

import com.amarket.apiserver.model.dto.product.ProductResponse;
import com.amarket.apiserver.model.dto.seller.SellerResponse;
import com.amarket.apiserver.model.dto.user.UserCreateRequest;
import com.amarket.apiserver.model.dto.user.UserResponse;
import com.amarket.apiserver.model.dto.user.UserUpdateRequest;
import com.amarket.apiserver.model.entity.Seller;
import com.amarket.apiserver.model.entity.User;
import com.amarket.apiserver.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserResponse create(UserCreateRequest reqDto) {
        User user = userRepository.save(UserCreateRequest.toEntity(reqDto));

        return UserResponse.fromEntity(user);
    }

    @Transactional
    public UserResponse findById(String id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found User. id=" + id);
        }
        return UserResponse.fromEntity(byId.get());
    }

    @Transactional
    public UserResponse update(String id, UserUpdateRequest reqDto) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found User. id=" + id);
        }
        User user = byId.get();
        user.update(reqDto.toEntity());
        return UserResponse.fromEntity(user);
    }

    @Transactional
    public void delete(String id) throws Exception {
        Optional<User> byId = userRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found User. id=" + id);
        }
        User user = byId.get();
        userRepository.delete(user);
    }
}
