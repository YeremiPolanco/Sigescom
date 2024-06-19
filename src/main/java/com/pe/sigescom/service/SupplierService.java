package com.pe.sigescom.service;

import com.pe.sigescom.repository.enity.Supplier;

import java.util.List;

public interface SupplierService {
    Supplier save(Supplier supplier);
    Supplier getById(Integer supplierId);
    List<Supplier> getAll();
    Supplier update(Integer supplierId, Supplier supplier);
    void delete(Integer supplierId);
}
