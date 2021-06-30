package com.rapisolver.rapisolveruserservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecommendationRequestDTO {

    private double mark;
    private String note;
    private UserDTO user;
}
