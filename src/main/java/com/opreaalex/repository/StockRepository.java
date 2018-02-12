package com.opreaalex.repository;

import com.opreaalex.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, BigInteger> {

    List<Stock> findAll();

    Optional<Stock> findById(BigInteger id);
}
