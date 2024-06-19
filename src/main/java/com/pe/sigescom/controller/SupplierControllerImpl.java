package com.pe.sigescom.controller;

import com.pe.sigescom.controller.dto.ResponseDto;
import com.pe.sigescom.repository.enity.Supplier;
import com.pe.sigescom.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/supplier")
public class SupplierControllerImpl implements SupplierController {
    private final SupplierService service;

    @Override
    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@RequestBody Supplier supplier) {
        try {
            Supplier createdSupplier = service.save(supplier);
            ResponseDto responseDto = new ResponseDto(1, "Proveedor creado correctamente");
            return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
        } catch (Exception e) {
            ResponseDto errorDto = new ResponseDto(2, "Proveedor creado incorrectamente: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
        }
    }

    @Override
    @GetMapping("/{supplierId}")
    public ResponseEntity<Supplier> getById(@PathVariable Integer supplierId) {
        Supplier supplier = service.getById(supplierId);
        if (supplier != null) {
            return ResponseEntity.ok(supplier);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Supplier>> getAll() {
        List<Supplier> suppliers = service.getAll();
        if (!suppliers.isEmpty()) {
            return ResponseEntity.ok(suppliers);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Override
    @PutMapping("/{supplierId}")
    public ResponseEntity<ResponseDto> update(@PathVariable Integer supplierId, @RequestBody Supplier updatedSupplier) {
        try {
            Supplier supplier = service.getById(supplierId);
            if (supplier != null) {
                supplier.setName(updatedSupplier.getName());
                supplier.setAddress(updatedSupplier.getAddress());
                supplier.setPhone(updatedSupplier.getPhone());
                service.save(supplier);
                return ResponseEntity.ok(new ResponseDto(1, "Proveedor actualizado correctamente"));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto(2, "Error al actualizar la Proveedor: " + e.getMessage()));
        }
    }

    @Override
    @DeleteMapping("/{supplierId}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Integer supplierId) {
        try {
            service.delete(supplierId);
            ResponseDto responseDto = new ResponseDto(1, "Proveedor eliminado correctamente");
            return ResponseEntity.status(HttpStatus.OK).body(responseDto);
        }
        catch (Exception e){
            ResponseDto errorDto = new ResponseDto(2, "Error al eliminar la Proveedor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);

        }
    }
}
