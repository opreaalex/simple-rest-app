package com.opreaalex.dao;

import com.opreaalex.domain.Stock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InMemoryStockDAOTest {

    private InMemoryStockDAO dao;

    @Before
    public void setUp() {
        dao = new InMemoryStockDAO();
    }

    @Test
    public void testCreate() {
        Assert.assertEquals(new BigInteger("1"), dao.create("Test", new BigInteger("9001")));
    }

    @Test
    public void testFindAll() {
        final Stock stock1 = new Stock(new BigInteger("1"), "Test1", new BigInteger("9001"));
        final Stock stock2 = new Stock(new BigInteger("2"), "Test2", new BigInteger("9002"));
        final Stock stock3 = new Stock(new BigInteger("3"), "Test3", new BigInteger("9003"));
        final Stock stock4 = new Stock(new BigInteger("4"), "Test4", new BigInteger("9004"));
        final Stock stock5 = new Stock(new BigInteger("5"), "Test5", new BigInteger("9005"));

        dao.create("Test1", new BigInteger("9001"));
        dao.create("Test2", new BigInteger("9002"));
        dao.create("Test3", new BigInteger("9003"));
        dao.create("Test4", new BigInteger("9004"));
        dao.create("Test5", new BigInteger("9005"));

        final List<Stock> stocks = Arrays.asList(stock1, stock2, stock3, stock4, stock5);

        Assert.assertEquals(stocks, dao.findAll());
    }

    @Test
    public void testFindById() {
        final Stock stock = new Stock(new BigInteger("1"), "Test", new BigInteger("9001"));

        dao.create("Test", new BigInteger("9001"));

        Assert.assertEquals(Optional.of(stock), dao.findById(stock.getId()));
    }

    @Test
    public void testDelete() {
        final Stock stock = new Stock(new BigInteger("1"), "Test", new BigInteger("9001"));

        dao.create("Test", new BigInteger("9001"));

        // Test to see if this was indeed an existing entry
        Assert.assertTrue(dao.delete(stock));

        // Test when entry no longer exists
        Assert.assertFalse(dao.delete(stock));
    }
}
