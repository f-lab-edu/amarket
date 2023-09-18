package com.amarket.apiserver.service;

import com.amarket.apiserver.model.dto.useraddress.UserAddressCreateRequest;
import com.amarket.apiserver.model.dto.useraddress.UserAddressResponse;
import com.amarket.apiserver.model.dto.useraddress.UserAddressUpdateRequest;
import com.amarket.apiserver.model.entity.User;
import com.amarket.apiserver.model.entity.UserAddress;
import com.amarket.apiserver.repository.UserAddressRepository;
import com.amarket.apiserver.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAddressService {

    private UserAddressRepository userAddressRepository;

    private UserRepository userRepository;

    public UserAddressService(UserAddressRepository userAddressRepository, UserRepository userRepository) {
        this.userAddressRepository = userAddressRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Long create(UserAddressCreateRequest reqDto) throws Exception {
        Optional<User> byId = userRepository.findById(reqDto.getUserId());
        if (byId.isEmpty()) {
            throw new Exception("Not Found UserAddress userId. id=" + reqDto.getUserId());
        }

        UserAddress userAddress = UserAddressCreateRequest.toEntity(reqDto);
        userAddress.setUser(byId.get());
        UserAddress save = userAddressRepository.save(userAddress);
        return save.getId();
    }

    @Transactional
    public UserAddressResponse findById(Long id) throws Exception {
        Optional<UserAddress> byId = userAddressRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found UserAddress. id=" + id);
        }
        return UserAddressResponse.fromEntity(byId.get());
    }

    @Transactional
    public List<UserAddressResponse> findByUserId(String userId) throws Exception {
        List<UserAddress> addressList = userAddressRepository.findByUserId(userId);
        List<UserAddressResponse> addressResponseList = new ArrayList<>();
        for (UserAddress address : addressList) {
            addressResponseList.add(UserAddressResponse.fromEntity(address));
        }
        return addressResponseList;
    }

    @Transactional
    public Long update(Long id, UserAddressUpdateRequest reqDto) throws Exception {
        Optional<UserAddress> byId = userAddressRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found UserAddress. id=" + id);
        }
        UserAddress userAddress = byId.get();
        userAddress.update(UserAddressUpdateRequest.toEntity(reqDto));
        return userAddress.getId();
    }

    @Transactional
    public void delete(Long id) throws Exception {
        Optional<UserAddress> byId = userAddressRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found UserAddress. id=" + id);
        }
        UserAddress userAddress = byId.get();
        userAddressRepository.delete(userAddress);
    }
}
