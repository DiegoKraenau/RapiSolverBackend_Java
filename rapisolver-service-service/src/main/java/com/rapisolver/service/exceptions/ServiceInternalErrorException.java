package com.rapisolver.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ServiceInternalErrorException  extends RuntimeException{
    public ServiceInternalErrorException(String message){
        super(message);
    }
}
