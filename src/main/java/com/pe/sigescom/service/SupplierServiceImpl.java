package com.pe.sigescom.service;

import com.pe.sigescom.repository.dao.SupplierDao;
import com.pe.sigescom.repository.enity.Supplier;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{
    private final SupplierDao repository;

    @Override
    public Supplier save(Supplier supplier) {
        return repository.save(supplier);
    }

    @Override
    public Supplier getById(Integer supplierId) {
        return repository.findById(supplierId).orElse(null);
    }

    @Override
    public List<Supplier> getAll() {
        return repository.findAll();
    }

    @Override
    public Supplier update(Integer supplierId, Supplier updateSupplier) {
        Supplier existingSupplier = repository.findById(supplierId).orElse(null);
        if (existingSupplier != null){
            existingSupplier.setName(updateSupplier.getName());
            existingSupplier.setAddress(updateSupplier.getAddress());
            existingSupplier.setPhone(updateSupplier.getPhone());
            return repository.save(updateSupplier);
        }
        return null;
    }

    @Override
    public void delete(Integer supplierId) {
        repository.deleteById(supplierId);
    }
}
