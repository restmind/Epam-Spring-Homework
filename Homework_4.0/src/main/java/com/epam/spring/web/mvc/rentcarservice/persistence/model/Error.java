package com.epam.spring.web.mvc.rentcarservice.persistence.model;

import com.epam.spring.web.mvc.rentcarservice.persistence.model.enums.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Error {
    private String message;
    private ErrorType errorType;
    private LocalDateTime timeStamp;
}
