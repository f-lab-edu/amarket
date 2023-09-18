package com.amarket.apiserver.controller;

import com.amarket.apiserver.model.dto.user.UserCreateRequest;
import com.amarket.apiserver.model.dto.user.UserResponse;
import com.amarket.apiserver.model.dto.user.UserUpdateRequest;
import com.amarket.apiserver.service.UserService;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService UserService) {
        this.userService = UserService;
    }

    @PostMapping("")
    public UserResponse create(@RequestBody UserCreateRequest reqDto) throws Exception {
        return userService.create(reqDto);
    }

    @GetMapping("/{id}")
    public UserResponse findById(@PathVariable String id) throws Exception {
        return userService.findById(id);
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable String id, @RequestBody UserUpdateRequest reqDto) throws Exception {
        return userService.update(id, reqDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws Exception {
        userService.delete(id);
    }
}
