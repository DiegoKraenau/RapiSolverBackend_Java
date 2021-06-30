package com.rapisolver.rapisolveruserservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RecommendationScoreNotValidException extends RuntimeException {

    public RecommendationScoreNotValidException(String message) {
        super(message);
    }
}
