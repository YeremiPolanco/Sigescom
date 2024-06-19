package com.pe.sigescom.service;

import com.pe.sigescom.repository.enity.Category;
import com.pe.sigescom.repository.enity.Product;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    Category getById(Integer categoryId);
    List<Category> getAll();
    Category update(Integer categoryId, Category category);
    void delete(Integer categoryId);
}
