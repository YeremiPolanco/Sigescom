package com.pe.sigescom.service;

import com.pe.sigescom.controller.dto.SaleRequestDto;
import com.pe.sigescom.repository.dao.SaleDao;
import com.pe.sigescom.repository.enity.Sale;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {
    private final SaleDao saleRepository;

    public Sale salesProcess(SaleRequestDto saleRequestDto){
        return null;
    }
}
