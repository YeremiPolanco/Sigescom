package com.pe.sigescom.controller;

import com.pe.sigescom.controller.dto.ResponseDto;
import com.pe.sigescom.repository.enity.Category;
import com.pe.sigescom.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService service;

    @Override
    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@RequestBody Category category) {
        try {
            Category createdCategory = service.save(category);
            ResponseDto responseDto = new ResponseDto(1, "Categoria creada correctamente");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (Exception e) {
            ResponseDto errorDto = new ResponseDto(2, "Categoria creada incorrectamente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
        }
    }


    @Override
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> getById(@PathVariable Integer categoryId) {
        Category category = service.getById(categoryId);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> categories = service.getAll();
        if (!categories.isEmpty()) {
            return ResponseEntity.ok(categories);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @PutMapping("/{categoryId}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer categoryId, @RequestBody Category updatedCategory) {
        try {
            Category category = service.getById(categoryId);
            if (category != null) {
                category.setName(updatedCategory.getName());
                category.setDescription(updatedCategory.getDescription());
                service.save(category);
                return ResponseEntity.ok(new ResponseDto(1, "Categoría actualizada correctamente"));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(2, "Error al actualizar la categoría: " + e.getMessage()));
        }
    }

    @Override
    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer categoryId) {
        try {
            service.delete(categoryId);
            ResponseDto responseDto = new ResponseDto(1, "Categoria eliminada correctamente");
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }
        catch (Exception e){
                ResponseDto errorDto = new ResponseDto(2, "Error al eliminar la categoría: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);

        }
    }
}