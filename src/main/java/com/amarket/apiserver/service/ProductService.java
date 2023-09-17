package com.amarket.apiserver.service;

import com.amarket.apiserver.model.dto.product.ProductCreateRequest;
import com.amarket.apiserver.model.dto.product.ProductResponse;
import com.amarket.apiserver.model.dto.product.ProductUpdateRequest;
import com.amarket.apiserver.model.dto.seller.SellerResponse;
import com.amarket.apiserver.model.entity.Product;
import com.amarket.apiserver.model.entity.Seller;
import com.amarket.apiserver.repository.ProductRepository;
import com.amarket.apiserver.repository.SellerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.*;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    private SellerRepository sellerRepository;

    public ProductService(ProductRepository productRepository, SellerRepository sellerRepository) {
        this.productRepository = productRepository;
        this.sellerRepository = sellerRepository;
    }

    @Transactional
    public ProductResponse create(ProductCreateRequest reqDto) throws Exception {
//        Product product = ProductCreateRequest.toEntity(reqDto);
//        System.out.println("sellerId  : " + product.getSeller().getId());
//        Product save = productRepository.save(product);
//        return ProductResponse.fromEntity(save);

        Optional<Seller> sellerOptional = sellerRepository.findById(reqDto.getSellerId());
        if (!sellerOptional.isPresent()) {
            // 판매자가 존재하지 않는 경우 예외 처리를 수행할 수 있습니다.
            throw new IllegalArgumentException("Seller not found");
        }
        Product product = new Product();
        product.setName(reqDto.getName());
        product.setSeller(sellerOptional.get());

        try {
            productRepository.save(product);
        } catch (Exception e) {
            System.out.println("ERROR : " + e.getMessage());
            e.printStackTrace();
        }

        return ProductResponse.fromEntity(product);
    }

    @Transactional
    public ProductResponse findById(Long id) throws Exception {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found. id=" +  id);
        }
        return ProductResponse.fromEntity(byId.get());
    }

    @Transactional
    public ProductResponse update(Long id, ProductUpdateRequest reqDto) throws Exception {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found. id=" +  id);
        }
        Product product = byId.get();
        product.update(ProductUpdateRequest.toEntity(reqDto));
        return ProductResponse.fromEntity(product);
    }

    @Transactional
    public void delete(Long id) throws Exception {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found. id=" +  id);
        }
        productRepository.delete(byId.get());
    }


}
