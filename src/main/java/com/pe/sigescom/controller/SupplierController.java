package com.pe.sigescom.controller;

import com.pe.sigescom.controller.dto.ResponseDto;
import com.pe.sigescom.repository.enity.Supplier;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SupplierController {
    ResponseEntity<ResponseDto> save(Supplier supplier);
    ResponseEntity<Supplier> getById(Integer supplierId);
    ResponseEntity<List<Supplier>> getAll();
    ResponseEntity<ResponseDto> update(Integer supplierId, Supplier supplier);
    ResponseEntity<ResponseDto> delete(Integer supplierId);
}
