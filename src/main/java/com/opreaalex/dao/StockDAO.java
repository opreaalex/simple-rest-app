package com.opreaalex.dao;

import com.opreaalex.domain.Stock;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface StockDAO {

    /**
     * Creates the Stock in the storage.
     *
     * @param name The Stock's name.
     * @param amount The Stock's amount.
     * @return The new Stock's Id (if the operation was successful).
     */
    Stock create(String name, BigInteger amount);

    /**
     * Retrieve all Stocks from storage.
     *
     * @return A list of Stocks.
     */
    List<Stock> findAll();

    /**
     * Retrieve stored Stock using id.
     *
     * @param id The Stock's id.
     * @return The Stock.
     */
    Optional<Stock> findById(BigInteger id);

    /**
     * Updates the existing Stock.
     *
     * @param stock The Stock to update.
     * @return Stock updated successfully or not.
     * For example when the Stock does not exist.
     */
    boolean update(Stock stock);

    /**
     * Removes the Stock from storage.
     *
     * @param stock The Stock to remove.
     * @return True if the stock was removed - false if not found.
     */
    boolean delete(Stock stock);
}
