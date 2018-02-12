package com.opreaalex.service;

import com.opreaalex.dao.StockDAO;
import com.opreaalex.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Configuration
public class StockService {

    @Autowired
    private StockDAO stockDAO;

    public BigInteger create(final String name, final BigInteger amount) {
        return stockDAO.create(name, amount);
    }

    public List<Stock> findAll() {
        return stockDAO.findAll();
    }

    public Optional<Stock> findById(final BigInteger id) {
        return stockDAO.findById(id);
    }

    public boolean updateAmount(final BigInteger id, final BigInteger amount) {
        return stockDAO.findById(id)
                .map(stock -> stockDAO.update(
                        new Stock(stock.getId(), stock.getName(), amount)))
                .orElse(false);
    }
}
