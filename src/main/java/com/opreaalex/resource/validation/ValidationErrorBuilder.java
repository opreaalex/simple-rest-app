package com.opreaalex.resource.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ValidationErrorBuilder {

    private static final String MSG_FORMAT = "Validation failed. %d error(s)";

    public static ValidationError fromBindingErrors(final Errors errors) {
        final ValidationError error = new ValidationError(String.format(MSG_FORMAT, errors.getErrorCount()));
        for (final ObjectError objectError : errors.getAllErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }

        return error;
    }
}
