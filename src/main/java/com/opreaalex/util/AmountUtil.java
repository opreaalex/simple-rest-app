package com.opreaalex.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class AmountUtil {

    public static String toReadableFormat(final BigInteger amount) {
        return NumberFormat.getCurrencyInstance(Locale.US)
                .format(new BigDecimal(amount).movePointLeft(2));
    }
}
