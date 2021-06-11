package com.rapisolver.reservation.service.services.impl;

import com.rapisolver.reservation.service.dtos.CreateReservationDTO;
import com.rapisolver.reservation.service.dtos.ReservationDTO;
import com.rapisolver.reservation.service.dtos.UpdateReservationDTO;
import com.rapisolver.reservation.service.entities.Reservation;
import com.rapisolver.reservation.service.exceptions.BookingInternalErrorException;
import com.rapisolver.reservation.service.exceptions.BookingNotFoundException;
import com.rapisolver.reservation.service.exceptions.RapisolverException;
import com.rapisolver.reservation.service.repositories.LocationRepository;
import com.rapisolver.reservation.service.repositories.ReservationRepository;
import com.rapisolver.reservation.service.services.ReservationService;
import com.rapisolver.reservation.service.util.LocationConverter;
import com.rapisolver.reservation.service.util.ReservationConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    LocationConverter locationConverter;

    @Autowired
    ReservationConverter reservationConverter;

    @Override
    public List<ReservationDTO> findAll() throws RapisolverException {
        List<Reservation> reservations;
        try {
            reservations = reservationRepository.findAll();
        } catch (Exception e) {
            throw new BookingInternalErrorException(
                    "Error al obtener todas las reservas"
            );
        }

        return reservations
                .stream()
                .map(reservation -> reservationConverter.convertReservationToDTO(reservation))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO findById(Long reservationId) throws RapisolverException {
        Reservation reservationBD = reservationRepository
                .findById(reservationId)
                .orElseThrow( () -> new BookingNotFoundException("No se encontro la reservacion con Id:" + reservationId)
                );
        return reservationConverter.convertReservationToDTO(reservationBD);
    }

    @Override
    public ReservationDTO createReservation(CreateReservationDTO createReservationDTO) throws RapisolverException {
        return null;
    }

    @Override
    public ReservationDTO updateReservation(Long id, UpdateReservationDTO updateReservationDTO) throws RapisolverException {
        return null;
    }

    @Override
    public String deleteReservation(Long id) throws RapisolverException {
        reservationRepository
                .findById(id)
                .orElseThrow(() -> new BookingInternalErrorException("ID_NOTFOUND"));
        try {
            reservationRepository.deleteById(id);
        } catch (Exception ex) {
            throw new BookingInternalErrorException("Error interno");
        }
        return "RESERVATION_DELETED";
    }
}
