package com.pe.sigescom.controller;

import com.pe.sigescom.controller.dto.ResponseDto;
import com.pe.sigescom.repository.enity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {
    ResponseEntity<ResponseDto> save(Product product);
    ResponseEntity<Product> getById(Integer productId);
    ResponseEntity<List<Product>> getAll();
    ResponseEntity<ResponseDto> update(Integer productId, Product product);
    ResponseEntity<ResponseDto> delete(Integer productId);
}
