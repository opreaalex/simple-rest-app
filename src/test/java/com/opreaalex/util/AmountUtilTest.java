package com.opreaalex.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class AmountUtilTest {

    @Test
    public void testToReadableFormat() {
        final BigInteger input = new BigInteger("9001");

        Assert.assertEquals("$90.01", AmountUtil.toReadableFormat(input));
    }
}
