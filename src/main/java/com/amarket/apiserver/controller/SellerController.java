package com.amarket.apiserver.controller;

import com.amarket.apiserver.common.response.CommonResponse;
import com.amarket.apiserver.model.dto.SellerCreateReqDto;
import com.amarket.apiserver.model.dto.SellerResDto;
import com.amarket.apiserver.model.dto.SellerUpdateReqDto;
import com.amarket.apiserver.model.entity.Seller;
import com.amarket.apiserver.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class SellerController {

    private final SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping("/seller/create")
    public CommonResponse<SellerResDto> create(@RequestBody SellerCreateReqDto reqDto) {
        return new CommonResponse<>(sellerService.create(reqDto));
    }

    @GetMapping("/seller/{id}")
    public CommonResponse<SellerResDto> create(@PathVariable String id) throws Exception {
        return new CommonResponse<>(sellerService.findById(id));
    }

    @PostMapping("/seller/update{id}")
    public CommonResponse<SellerResDto> create(@PathVariable String id,
                                               @RequestBody SellerUpdateReqDto reqDto) throws Exception {
        return new CommonResponse<>(sellerService.update(id, reqDto));
    }

    @DeleteMapping("/seller/delete/{id}")
    public void delete(@PathVariable String id) throws Exception {
        sellerService.delete(id);
    }

}
