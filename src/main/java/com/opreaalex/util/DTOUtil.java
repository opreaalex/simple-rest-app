package com.opreaalex.util;

import com.opreaalex.domain.Stock;
import com.opreaalex.dto.StockDTO;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DTOUtil {

    /**
     * Transforms the given DTO to a human-friendly readable format
     * @param dto The StockDTO to transform.
     * @return A 1-to-1 Map containing human-friendly fields.
     */
    public static Map<String, String> stockDtoToPrintableFormat(
            final StockDTO dto) {
        final Stock stock = dto.getStock();
        final Map<String, String> map = new HashMap<>();
        map.put("id", stock.getId().toString());
        map.put("name", stock.getName());
        map.put("amount", amountToPrintableFormat(stock.getAmount()));

        return map;
    }

    public static String amountToPrintableFormat(final BigInteger amount) {
        return NumberFormat.getCurrencyInstance(Locale.US)
                .format(new BigDecimal(amount).movePointLeft(2));
    }
}
