package com.opreaalex.resource.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateStockForm {

    @NotNull(message = "name must not be null")
    @Pattern(regexp = "^[a-zA-Z0-9_]*$",
             message = "name must only contain alphanumeric characters")
    private String name;

    @NotNull(message = "currentPrice must not be null")
    @Pattern(regexp = "^0|[1-9]\\d*$",
            message = "currentPrice must be a positive integer")
    private String currentPrice;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setAmount(final String currentPrice) {
        this.currentPrice = currentPrice;
    }
}
