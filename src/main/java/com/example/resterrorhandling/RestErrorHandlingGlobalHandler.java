package com.example.resterrorhandling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestErrorHandlingGlobalHandler {

    @ExceptionHandler(RestErrorHandlingException.class)
    public ResponseEntity<ErrorInfoDefinition> handleServiceException(RestErrorHandlingException exception) {
        log.error("RestErrorHandlingException: ", exception);
        var errorInfo = exception.getRestErrorInfoDefinition();
        return switch (errorInfo.getType()) {
            case VALIDATION_ERROR -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorInfo);
            case BUSINESS_ERROR -> ResponseEntity.status(HttpStatus.OK).body(errorInfo);
            case OTHER_ERROR -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorInfo);
        };
    }
}
