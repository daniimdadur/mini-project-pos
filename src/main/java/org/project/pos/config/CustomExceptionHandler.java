package org.project.pos.config;

import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.project.pos.base.Response;
import org.project.pos.util.CommonUtil;
import org.project.pos.util.ConstantApp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@RequiredArgsConstructor
public class CustomExceptionHandler {

    private final CommonUtil commonUtil;

//    @ExceptionHandler(value = {Exception.class})
//    public ResponseEntity<Response> handleException(final Exception e) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .header(ConstantApp.TRANSACTION_ID, commonUtil.)
//    }
}
