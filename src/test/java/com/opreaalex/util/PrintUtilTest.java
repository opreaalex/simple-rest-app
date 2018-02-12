package com.opreaalex.util;

import com.opreaalex.domain.Stock;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class PrintUtilTest {

    @Test
    public void testStockDtoToPrintableFormat() {
        final Stock stock = new Stock(
                new BigInteger("1"),
                "Test",
                new BigInteger("1000"));

        final Map<String, String> expected = new HashMap<>();
        expected.put("id", "1");
        expected.put("name", "Test");
        expected.put("currentPrice", "$10.00");
        expected.put("lastUpdate", "");

        Assert.assertEquals(expected,
                PrintUtil.toUserFriendlyStock(stock));
    }

    @Test
    public void testAmountToPrintableFormat() {
        final BigInteger input = new BigInteger("9001");

        Assert.assertEquals("$90.01",
                PrintUtil.toUserFriendlyAmount(input));
    }
}
