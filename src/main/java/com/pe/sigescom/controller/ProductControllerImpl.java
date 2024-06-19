package com.pe.sigescom.controller;

import com.pe.sigescom.controller.dto.ResponseDto;
import com.pe.sigescom.repository.enity.Category;
import com.pe.sigescom.repository.enity.Product;
import com.pe.sigescom.repository.enity.Supplier;
import com.pe.sigescom.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductControllerImpl implements ProductController{
    private final ProductService service;

    @Override
    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@RequestBody Product product) {
        try {
            Product createdProduct = service.save(product);
            ResponseDto responseDto = new ResponseDto(1, "Producto creado correctamente");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (Exception e) {
            ResponseDto errorDto = new ResponseDto(2, "Producto creado incorrectamente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
        }
    }

    @Override
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getById(@PathVariable Integer productId) {
        Product product = service.getById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        List<Product> products = service.getAll();
        if (!products.isEmpty()) {
            return ResponseEntity.ok(products);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @PutMapping("/{productId}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer productId, @RequestBody Product updatedProduct) {
        try {
            Product product = service.getById(productId);
            if (product != null) {
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                product.setCost(updatedProduct.getCost());
                product.setQuantity(updatedProduct.getQuantity());
                product.setStatus(updatedProduct.getStatus());
                product.setCategory(updatedProduct.getCategory());
                product.setSupplier(updatedProduct.getSupplier());
                product.setImage(updatedProduct.getImage());
                service.save(product);
                return ResponseEntity.ok(new ResponseDto(1, "Producto actualizado correctamente"));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(2, "Error al actualizar la Producto: " + e.getMessage()));
        }
    }

    @Override
    @DeleteMapping("/{productId}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer productId) {
        try {
            service.delete(productId);
            ResponseDto responseDto = new ResponseDto(1, "Producto eliminado correctamente");
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }
        catch (Exception e){
            ResponseDto errorDto = new ResponseDto(2, "Error al eliminar la Producto: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);

        }
    }
}
