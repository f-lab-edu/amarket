package com.amarket.apiserver.controller;

import com.amarket.apiserver.model.dto.product.ProductCreateRequest;
import com.amarket.apiserver.model.dto.product.ProductResponse;
import com.amarket.apiserver.model.dto.product.ProductUpdateRequest;
import com.amarket.apiserver.model.entity.Product;
import com.amarket.apiserver.service.ProductService;
import org.springframework.web.bind.annotation.*;



@RequestMapping(path = "/api/v1/products")
@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("")
    public ProductResponse create(@RequestBody ProductCreateRequest reqDto) throws Exception {
        return productService.create(reqDto);
    }

    @GetMapping("/{id}")
    public ProductResponse findById(@PathVariable Long id) throws Exception {
        return productService.findById(id);
    }

    @PutMapping("/{id}")
    public ProductResponse update(@PathVariable Long id, @RequestParam ProductUpdateRequest reqDto) throws Exception {
        return productService.update(id, reqDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws Exception {
        productService.delete(id);
    }
}
