package com.opreaalex.resource;

import com.opreaalex.service.StockService;
import com.opreaalex.util.AmountUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WebResource {

    @Autowired
    private StockService stockService;

    @RequestMapping("/")
    public String getIndex(final Map<String, Object> modelMap) {
        List<Map<String, String>> stocks = stockService.findAll()
                .stream()
                .map(stock -> {
                    final Map<String, String> stockMap = new HashMap<>();
                    stockMap.put("id", stock.getId().toString());
                    stockMap.put("name", stock.getName());
                    stockMap.put("amount", AmountUtil.toReadableFormat(stock.getAmount()));

                    return stockMap;
                })
                .collect(Collectors.toList());
        modelMap.put("stocks", stocks);
        return "index";
    }
}
