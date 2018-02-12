package com.opreaalex.resource.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CreateStockForm {

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9_]*$",
             message = "name must only contain alphanumeric characters")
    private String name;

    @NotNull
    @Pattern(regexp = "^0|[1-9]\\d*$",
            message = "amount must be a positive integer")
    private String amount;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }
}
