package com.pe.sigescom.service;

import com.pe.sigescom.repository.dao.ProductDao;
import com.pe.sigescom.repository.enity.Product;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.loadtime.Options;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductDao repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getById(Integer productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product update(Integer productId, Product updatedProduct) {
        Product existingProduct = repository.findById(productId).orElse(null);
        if (existingProduct != null) {
            // Actualizar los campos del producto existente con los valores del producto actualizado
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setCost(updatedProduct.getCost());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            existingProduct.setStatus(updatedProduct.getStatus());
            existingProduct.setSupplier(updatedProduct.getSupplier());
            existingProduct.setCategory(updatedProduct.getCategory());
            existingProduct.setImage(updatedProduct.getImage());
            return repository.save(existingProduct);
        }
        return null;
    }

    @Override
    public void delete(Integer productId) {
            repository.deleteById(productId);
    }
}
