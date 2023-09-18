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
    public Long create(ProductCreateRequest reqDto) throws Exception {
        Optional<Seller> sellerOptional = sellerRepository.findById(reqDto.getSellerId());
        if (sellerOptional.isEmpty()) {
            throw new IllegalArgumentException("Seller not found : " + reqDto.getSellerId());
        }

        Product product = ProductCreateRequest.toEntity(reqDto);
        // setter 안쓰고 seller 주입 방법?
        product.setSeller(sellerOptional.get());
        Product save = productRepository.save(product);
        return save.getId();
    }

    @Transactional
    public ProductResponse findById(Long id) throws Exception {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new Exception("Not Found. id=" +  id);
        }
        Product product = byId.get();

        // CASE 1
        ProductResponse productResponse = new ProductResponse();
        productResponse.setPrice(product.getPrice());
        return productResponse;

        // CASE 2
        //return ProductResponse.fromEntity(product);
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
