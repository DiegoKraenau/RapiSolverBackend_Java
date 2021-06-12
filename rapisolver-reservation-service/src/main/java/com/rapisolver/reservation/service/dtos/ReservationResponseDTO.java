package com.rapisolver.reservation.service.dtos;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class ReservationResponseDTO {
    private String country;

    private String state;

    private String city;

    private String address;

    private Long userId;

    private Long supplierAttentionId;

    private Date dateRequested;

    private String comment;
}
