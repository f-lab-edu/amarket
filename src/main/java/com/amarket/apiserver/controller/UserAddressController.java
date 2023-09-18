package com.amarket.apiserver.controller;

import com.amarket.apiserver.model.dto.useraddress.UserAddressCreateRequest;
import com.amarket.apiserver.model.dto.useraddress.UserAddressResponse;
import com.amarket.apiserver.model.dto.useraddress.UserAddressUpdateRequest;
import com.amarket.apiserver.model.entity.UserAddress;
import com.amarket.apiserver.service.UserAddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/user-addresses")
@RestController
public class UserAddressController {

    private UserAddressService userAddressService;

    public UserAddressController(UserAddressService userAddressService) {
        this.userAddressService = userAddressService;
    }

    @PostMapping("")
    public Long create(@RequestBody UserAddressCreateRequest reqDto) throws Exception {
        return userAddressService.create(reqDto);
    }

    @GetMapping("/{id}")
    public UserAddressResponse findById(@PathVariable Long id) throws Exception {
        return userAddressService.findById(id);
    }

    @GetMapping("/list")
    public List<UserAddressResponse> findByUserId(@RequestParam(name = "userid") String userId) throws Exception {
        return userAddressService.findByUserId(userId);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody UserAddressUpdateRequest reqDto) throws Exception {
        return userAddressService.update(id, reqDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        userAddressService.delete(id);
    }
}
