package com.amarket.apiserver.repository;

import com.amarket.apiserver.model.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, String> {
}
