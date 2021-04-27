package com.epam.spring.web.mvc.rentcarservice.exception;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.enums.ErrorType;

public class CarNotFoundException extends ServiceException {
    private static final String DEFAULT_MESSAGE = "Car is not found";

    public CarNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public CarNotFoundException(String message) {
        super(message);
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DATABASE_ERROR_TYPE;
    }
}
