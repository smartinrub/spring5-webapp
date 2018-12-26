package org.smartinrubio.spring5webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Hotel Not Found")
public class HotelNotFoundException extends RuntimeException {
    public HotelNotFoundException(Exception e) {
        super(e);
    }
}
