package org.smartinrubio.spring5webapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "User Already Exists")
public class DuplicateUserException extends RuntimeException {
}
