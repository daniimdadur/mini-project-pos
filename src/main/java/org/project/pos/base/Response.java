package org.project.pos.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Response<T> {
    private int code;
    private Object statusCode;
    private T data;
    private List<FieldError> errors = new ArrayList<>();
    private int total;
}
