package com.amarket.apiserver.service;

import com.amarket.apiserver.model.dto.seller.SellerCreateRequest;
import com.amarket.apiserver.model.dto.seller.SellerResponse;
import com.amarket.apiserver.model.dto.seller.SellerUpdateRequest;
import com.amarket.apiserver.model.entity.Seller;
import com.amarket.apiserver.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    @Transactional
    public SellerResponse create(SellerCreateRequest reqDto) {
        Seller seller = reqDto.toEntity(reqDto);
        Seller save = sellerRepository.save(seller);
        return SellerResponse.fromEntity(save);
    }

    @Transactional
    public SellerResponse findById(String id) throws Exception {
        Optional<Seller> byId = sellerRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found Seller. id=" + id);
        }
        return SellerResponse.fromEntity(byId.get());
    }

    @Transactional
    public SellerResponse update(String id, SellerUpdateRequest reqDto) throws Exception {
        Optional<Seller> byId = sellerRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found Seller. id=" + id);
        }
        Seller seller = byId.get();
        seller.update(reqDto.toEntity());
        return SellerResponse.fromEntity(seller);
    }

    @Transactional
    public void delete(String id) throws Exception {
        Optional<Seller> byId = sellerRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found Seller. id=" + id);
        }
        Seller seller = byId.get();
        sellerRepository.delete(seller);
    }
}
