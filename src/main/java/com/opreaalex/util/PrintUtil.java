package com.opreaalex.util;

import com.opreaalex.domain.Stock;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PrintUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Transforms the given Stock to a human-friendly readable format.
     *
     * @param stock The Stock to transform.
     * @return A 1-to-1 Map containing human-friendly fields.
     */
    public static Map<String, String> toUserFriendlyStock(final Stock stock) {
        final Map<String, String> map = new HashMap<>();
        map.put("id", stock.getId().toString());
        map.put("name", stock.getName());
        map.put("currentPrice", toUserFriendlyAmount(stock.getAmount()));
        map.put("lastUpdate", stock.getUpdateDateTime()
                .map(dt -> dt.withZoneSameInstant(ZoneId.systemDefault()))
                .map(FORMATTER::format)
                .orElse(""));

        return map;
    }

    public static String toUserFriendlyAmount(final BigInteger amount) {
        return NumberFormat.getCurrencyInstance(Locale.US)
                .format(new BigDecimal(amount).movePointLeft(2));
    }
}
