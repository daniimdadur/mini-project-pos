package org.project.pos.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
public class ExceptionApp extends RuntimeException{
    private final HttpStatus status;
    private final String message;
    private final List<FieldError> errors;

    public ExceptionApp(HttpStatus status, String message, List<FieldError> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ExceptionApp(String message, List<FieldError> errors) {
        super(message);
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.message = message;
        this.errors = errors;
    }

    public ExceptionApp(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
        this.errors = null;
    }
}
