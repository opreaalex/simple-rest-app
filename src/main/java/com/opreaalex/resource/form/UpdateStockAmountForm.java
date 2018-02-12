package com.opreaalex.resource.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateStockAmountForm {

    @NotNull(message = "currentPrice must not be null")
    @Pattern(regexp = "^0|[1-9]\\d*$",
            message = "currentPrice must be a positive integer")
    private String currentPrice;

    public String getCurrentPrice() {
        return currentPrice;
    }

    public void setAmount(final String currentPrice) {
        this.currentPrice = currentPrice;
    }
}
