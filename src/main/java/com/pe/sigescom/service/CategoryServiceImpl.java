package com.pe.sigescom.service;

import com.pe.sigescom.repository.dao.CategoryDao;
import com.pe.sigescom.repository.enity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryDao repository;
    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category getById(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category update(Integer categoryId, Category updateCategory) {
        Category existingCategory = repository.findById(categoryId).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(updateCategory.getName());
            existingCategory.setDescription(updateCategory.getDescription());
            return repository.save(updateCategory);
        }
        return null;
    }

    @Override
    public void delete(Integer categoryId) {
        // Llama al método de eliminación en tu capa de acceso a datos
        repository.deleteById(categoryId);
    }

}
