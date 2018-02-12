package com.opreaalex.service;

import com.opreaalex.dao.StockDAO;
import com.opreaalex.domain.Stock;
import com.opreaalex.dto.StockDTO;
import com.opreaalex.util.DTOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Configuration
public class StockService {

    @Autowired
    private StockDAO stockDAO;

    @Autowired
    private SimpMessagingTemplate template;

    public Stock create(final String name, final BigInteger amount) {
        final Stock stock = stockDAO.create(name, amount);
        handleCreateWS(stock);
        return stock;
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

    private void handleCreateWS(final Stock stock) {
        // Method will broadcast a Stock creation to Web Socket listeners
        template.convertAndSend("/topic/stocks",
                DTOUtil.stockDtoToPrintableFormat(new StockDTO(stock)));
    }
}
