package com.example.resterrorhandling;

import lombok.Getter;

@Getter
@SuppressWarnings("unused")
public class RestErrorHandlingException extends RuntimeException {

    private final ErrorInfoDefinition restErrorInfoDefinition;

    public RestErrorHandlingException(String message, ErrorInfoDefinition restErrorInfoDefinition) {
        super(message);
        this.restErrorInfoDefinition = restErrorInfoDefinition;
    }

    public RestErrorHandlingException(ErrorInfoDefinition restErrorInfoDefinition) {
        super(restErrorInfoDefinition.getCodeMeaning());
        this.restErrorInfoDefinition = restErrorInfoDefinition;
    }
}
