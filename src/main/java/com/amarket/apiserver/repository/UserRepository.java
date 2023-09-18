package com.amarket.apiserver.repository;

import com.amarket.apiserver.model.entity.Product;
import com.amarket.apiserver.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
