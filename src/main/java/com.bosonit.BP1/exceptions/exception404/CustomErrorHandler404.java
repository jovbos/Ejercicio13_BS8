package com.bosonit.BP1.exceptions.exception404;

import com.bosonit.BP1.exceptions.CustomError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomErrorHandler404 {

    @ExceptionHandler(value={CustomErrorRequest404.class})
    public ResponseEntity<Object> handlerError(CustomErrorRequest404 e) {
        CustomError customError = new CustomError(
                e.getMessage(),
                404,
                ZonedDateTime.now(ZoneId.of("UTC+1"))
        );
        return new ResponseEntity<>(customError, HttpStatus.NOT_FOUND);
    }

}
