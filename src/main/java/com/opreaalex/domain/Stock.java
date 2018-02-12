package com.opreaalex.domain;

import java.math.BigInteger;
import java.util.Objects;

public class Stock implements Comparable {

    private BigInteger id;

    private String name;

    private BigInteger amount;

    public Stock() {
    }

    public Stock(final BigInteger id,
                 final String name,
                 final BigInteger amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigInteger getAmount() {
        return amount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Stock stock = (Stock) o;
        return Objects.equals(id, stock.id) &&
                Objects.equals(name, stock.name) &&
                Objects.equals(amount, stock.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount);
    }

    @Override
    public int compareTo(final Object o) {
        if (this == o) {
            return 0;
        }
        if (o == null || getClass() != o.getClass()) {
            return 1;
        }
        final Stock stock = (Stock) o;
        if (id.compareTo(stock.getId()) == 0) {
            if (name.compareTo(stock.getName()) == 0) {
                return amount.compareTo(stock.getAmount());
            }
        }
        return 0;
    }
}
