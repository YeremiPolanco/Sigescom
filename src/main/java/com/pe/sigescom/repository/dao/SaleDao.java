package com.pe.sigescom.repository.dao;

import com.pe.sigescom.repository.enity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDao extends JpaRepository<Sale, Integer> {
}
