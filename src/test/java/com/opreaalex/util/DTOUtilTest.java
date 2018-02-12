package com.opreaalex.util;

import com.opreaalex.domain.Stock;
import com.opreaalex.dto.StockDTO;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class DTOUtilTest {

    @Test
    public void testStockDtoToPrintableFormat() {
        final Stock stock = new Stock(
                new BigInteger("1"),
                "Test",
                new BigInteger("1000"));
        final StockDTO dto = new StockDTO(stock);

        final Map<String, String> expected = new HashMap<>();
        expected.put("id", "1");
        expected.put("name", "Test");
        expected.put("amount", "$10.00");

        Assert.assertEquals(expected,
                DTOUtil.stockDtoToPrintableFormat(dto));
    }

    @Test
    public void testAmountToPrintableFormat() {
        final BigInteger input = new BigInteger("9001");

        Assert.assertEquals("$90.01",
                DTOUtil.amountToPrintableFormat(input));
    }
}
