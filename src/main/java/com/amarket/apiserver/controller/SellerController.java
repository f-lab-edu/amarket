package com.amarket.apiserver.controller;

import com.amarket.apiserver.model.dto.seller.SellerCreateRequest;
import com.amarket.apiserver.model.dto.seller.SellerResponse;
import com.amarket.apiserver.model.dto.seller.SellerUpdateRequest;
import com.amarket.apiserver.service.SellerService;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path = "/api/v1/sellers")
@RestController
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("")
    public SellerResponse create(@RequestBody SellerCreateRequest reqDto) {
        return sellerService.create(reqDto);
    }

    @GetMapping("/{id}")
    public SellerResponse findById(@PathVariable String id) throws Exception {
        return sellerService.findById(id);
    }

    @PutMapping("/{id}")
    public SellerResponse update(@PathVariable String id, @RequestBody SellerUpdateRequest reqDto) throws Exception {
        return sellerService.update(id, reqDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) throws Exception {
        sellerService.delete(id);
    }

}
