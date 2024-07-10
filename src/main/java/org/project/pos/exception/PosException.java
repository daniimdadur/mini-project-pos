package org.project.pos.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@RequiredArgsConstructor
@Getter
public class PosException extends RuntimeException {
    private final HttpStatus status;
    private final Object errors;

}
