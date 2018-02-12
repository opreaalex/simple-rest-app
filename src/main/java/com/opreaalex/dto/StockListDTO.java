package com.opreaalex.dto;

import com.opreaalex.domain.Stock;

import java.util.List;

public class StockListDTO {

    private List<Stock> stocks;

    public StockListDTO(final List<Stock> stocks) {
        this.stocks = stocks;
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
