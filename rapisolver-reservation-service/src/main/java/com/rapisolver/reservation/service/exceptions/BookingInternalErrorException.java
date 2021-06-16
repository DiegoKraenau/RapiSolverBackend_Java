package com.rapisolver.reservation.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BookingInternalErrorException extends RuntimeException {
    public BookingInternalErrorException(String message) {
        super(message);
    }
}
