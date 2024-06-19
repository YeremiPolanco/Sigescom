package com.pe.sigescom.service;

import com.pe.sigescom.repository.enity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    Product getById(Integer productId);
    List<Product> getAll();
    Product update(Integer productId, Product product);
    void delete(Integer productId);
}
