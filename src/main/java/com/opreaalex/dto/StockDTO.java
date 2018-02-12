package com.opreaalex.dto;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.opreaalex.domain.Stock;

public class StockDTO {

    @JsonUnwrapped
    private Stock stock;

    public StockDTO (final Stock stock) {
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }
}
