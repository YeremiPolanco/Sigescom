package com.pe.sigescom.controller;

import com.pe.sigescom.controller.dto.ResponseDto;
import com.pe.sigescom.repository.enity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoryController {
    ResponseEntity<ResponseDto> save(Category category);
    ResponseEntity<Category> getById(Integer categoryId);
    ResponseEntity<List<Category>> getAll();
    ResponseEntity<ResponseDto> update(Integer categoryId, Category category);
    ResponseEntity<ResponseDto> delete(Integer categoryId);
}
