package org.smartinrubio.spring5webapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class WepAppExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public String hotelNotFoundHandler() {
        return "error/notFound";
    }

    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundHandler() {
        return "error/notFound";
    }

    @ExceptionHandler(DuplicateUserException.class)
    public String duplicateUserHandler() {
        return "error/duplicate";
    }

}
