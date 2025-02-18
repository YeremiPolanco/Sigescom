package com.pe.sigescom.repository.dao;

import com.pe.sigescom.repository.enity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierDao extends JpaRepository<Supplier, Integer> {
}
