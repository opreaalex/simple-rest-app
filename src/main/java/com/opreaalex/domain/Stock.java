package com.opreaalex.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;

public class Stock implements Comparable {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    private BigInteger id;

    private String name;

    @JsonProperty("currentPrice")
    private BigInteger amount;

    @JsonIgnore // Will be represented as lastUpdate
    private ZonedDateTime updateDateTime;

    private String lastUpdate;

    public Stock() {
    }

    public Stock(final BigInteger id,
                 final String name,
                 final BigInteger amount) {
        this(id, name, amount, null);
    }

    public Stock(final BigInteger id,
                 final String name,
                 final BigInteger amount,
                 final ZonedDateTime updateDateTime) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.updateDateTime = updateDateTime;
        if (updateDateTime != null) {
            this.lastUpdate = FORMATTER.format(updateDateTime);
        }
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

    public Optional<ZonedDateTime> getUpdateDateTime() {
        return Optional.ofNullable(updateDateTime);
    }

    public String getLastUpdate() {
        return lastUpdate;
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
                Objects.equals(amount, stock.amount) &&
                Objects.equals(updateDateTime, stock.updateDateTime);
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
        if (id.compareTo(stock.id) == 0) {
            if (name.compareTo(stock.name) == 0) {
                if (amount.compareTo(stock.amount) == 0) {
                    return updateDateTime.compareTo(stock.updateDateTime);
                }
            }
        }
        return 0;
    }
}
