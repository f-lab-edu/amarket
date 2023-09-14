package com.amarket.apiserver.service;

import com.amarket.apiserver.model.dto.SellerCreateReqDto;
import com.amarket.apiserver.model.dto.SellerResDto;
import com.amarket.apiserver.model.dto.SellerUpdateReqDto;
import com.amarket.apiserver.model.entity.Seller;
import com.amarket.apiserver.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public SellerResDto create(SellerCreateReqDto reqDto) {
        log.info("reqDto={}", reqDto);
        Seller seller = reqDto.toEntity();
        log.info("seller={}", seller);

        Seller save = sellerRepository.save(seller);
        System.out.println("save : " + save);

        SellerResDto sellerResDto = SellerResDto.fromEntity(save);

        System.out.println("sellerResDto : " + sellerResDto);

        return sellerResDto;
    }

    public SellerResDto findById(String id) throws Exception {
        Optional<Seller> byId = sellerRepository.findById(id);
        if (!byId.isPresent()) {
            throw new Exception("NotFound Seller. id=" + id);
        }

        return SellerResDto.fromEntity(byId.get());
    }

    public SellerResDto update(String id, SellerUpdateReqDto reqDto) throws Exception {
        Optional<Seller> byId = sellerRepository.findById(id);
        if (!byId.isPresent()) {
            throw new Exception("NotFound Seller. id=" + id);
        }

        Seller seller = byId.get();
        seller.update(reqDto);

        return SellerResDto.fromEntity(sellerRepository.save(seller));
    }


    public void delete(String id) throws Exception {
        Optional<Seller> byId = sellerRepository.findById(id);
        if (!byId.isPresent()) {
            throw new Exception("NotFound Seller. id=" + id);
        }
        Seller seller = byId.get();
        sellerRepository.delete(seller);
    }
}
