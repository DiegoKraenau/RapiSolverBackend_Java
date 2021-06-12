package com.rapisolver.reservation.service.services;

import com.rapisolver.reservation.service.dtos.CreateReservationDTO;
import com.rapisolver.reservation.service.dtos.ReservationDTO;
import com.rapisolver.reservation.service.dtos.UpdateReservationDTO;
import com.rapisolver.reservation.service.exceptions.RapisolverException;

import java.util.List;

public interface ReservationService {
    List<ReservationDTO> findAll() throws RapisolverException;
    ReservationDTO findById(Long reservationId) throws RapisolverException;
    ReservationDTO createReservation(CreateReservationDTO createReservationDTO)
            throws RapisolverException;
    ReservationDTO updateReservation(
            Long id,
            UpdateReservationDTO updateReservationDTO
    )
            throws RapisolverException;
    String deleteReservation(Long id) throws RapisolverException;
}
