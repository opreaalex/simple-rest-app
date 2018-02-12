package com.opreaalex.resource.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateStockAmountForm {

    @NotNull
    @Pattern(regexp = "^0|[1-9]\\d*$",
            message = "amount must be a positive integer")
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }
}
