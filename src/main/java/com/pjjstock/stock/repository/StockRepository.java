package com.pjjstock.stock.repository;

import com.pjjstock.stock.domain.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
