package com.pe.sigescom.repository.dao;

import com.pe.sigescom.repository.enity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleDetailDao extends JpaRepository<SaleDetail, Integer> {
}
