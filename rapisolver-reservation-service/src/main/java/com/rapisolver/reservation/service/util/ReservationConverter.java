package com.rapisolver.reservation.service.util;

import com.rapisolver.reservation.service.dtos.ReservationDTO;
import com.rapisolver.reservation.service.entities.Reservation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ReservationConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ReservationDTO convertReservationToDTO(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDTO.class);
    }

    public Reservation convertReservationToEntity(ReservationDTO reservationDTO) {
        return modelMapper.map(reservationDTO, Reservation.class);
    }
}