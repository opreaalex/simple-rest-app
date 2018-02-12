package com.opreaalex.dao;

import com.opreaalex.domain.Stock;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
public class InMemoryStockDAO implements StockDAO {

    private Map<BigInteger, Stock> stockMap = new HashMap<>();

    @Override
    public Stock create(final String name, final BigInteger amount) {
        synchronized (this) {
            final BigInteger id = getNextId();
            final Stock stock = new Stock(id, name, amount);
            stockMap.put(id, stock);

            return stock;
        }
    }

    @Override
    public List<Stock> findAll() {
        return stockMap.values()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Stock> findById(final BigInteger id) {
        return Optional.ofNullable(stockMap.get(id));
    }

    @Override
    public boolean update(final Stock stock) {
        synchronized (this) {
            if (!stockMap.containsKey(stock.getId())) {
                return false;
            }
            stockMap.put(stock.getId(), stock);

            return true;
        }
    }

    @Override
    public boolean delete(final Stock stock) {
        synchronized (this) {
            final boolean exists = stockMap.containsKey(stock.getId());
            stockMap.remove(stock.getId());

            return exists;
        }
    }

    private BigInteger getNextId() {
        return new BigInteger(Integer.toString(stockMap.size() + 1));
    }
}
