package com.opreaalex.resource;

import com.opreaalex.service.StockService;
import com.opreaalex.util.PrintUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
                .map(PrintUtil::toUserFriendlyStock)
                .collect(Collectors.toList());
        modelMap.put("stocks", stocks);

        return "index";
    }
}
