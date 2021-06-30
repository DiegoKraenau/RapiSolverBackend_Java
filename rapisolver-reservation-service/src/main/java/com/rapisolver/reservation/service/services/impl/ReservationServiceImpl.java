package com.rapisolver.reservation.service.services.impl;

import com.rapisolver.reservation.service.client.ServiceServiceClient;
import com.rapisolver.reservation.service.client.UserServiceClient;
import com.rapisolver.reservation.service.dtos.*;
import com.rapisolver.reservation.service.entities.Location;
import com.rapisolver.reservation.service.entities.Reservation;
import com.rapisolver.reservation.service.enums.StatusOrder;
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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private UserServiceClient userClient;

    @Autowired
    private ServiceServiceClient serviceClient;

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
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public ReservationDTO createReservation(CreateReservationDTO createReservationDTO)throws RapisolverException {
        Reservation reservation = new Reservation();
        Location location = locationConverter.convertLocationToEntity(createReservationDTO);


        UserDTO usuario = userClient.findUserById(createReservationDTO.getUserId())
                            .orElseThrow(() -> new BookingNotFoundException("USER_NOT_FOUND"));


        SupplierAttentionDTO supplierAttention = serviceClient.findSupplierAttentionById(createReservationDTO.getSupplierAttentionId())
                .orElseThrow(() -> new BookingNotFoundException("ATTENTION_NOT_FOUND"));

        try {
            ReservationDTO reservationDTO = new ReservationDTO();
            location = locationRepository.save(location);
            reservation.setLocation(location);
            reservation.setUserId(usuario.getId());
            reservation.setSupplierAttentionId(supplierAttention.getId());
            reservation.setDateRequested(createReservationDTO.getDateRequested());
            reservation.setComment(createReservationDTO.getComment());
      /*
            1:Pendiente
            2:Finalizado
             */
            reservation.setStatus(StatusOrder.ORDERED);
            reservation = reservationRepository.save(reservation);

            //Mapping
            reservationDTO = reservationConverter.convertReservationToDTO(reservation);
            reservationDTO.setCountry(location.getCountry());
            reservationDTO.setAddress(location.getAddress());
            reservationDTO.setCity(location.getCity());
            reservationDTO.setState(location.getState());

            return reservationDTO;
        } catch (Exception e) {
            throw new BookingInternalErrorException("INTERNAL_SERVER_ERROR");
        }
    }

    @Override
    public ReservationDTO updateReservation(Long id,UpdateReservationDTO updateReservationDTO) throws RapisolverException {
        Reservation reservationDB = reservationRepository
                .findById(id)
                .orElseThrow(
                        () -> new BookingNotFoundException("Reservacion a actualizar no encontrado")
                );

        Location location = locationConverter.convertLocationToEntityEdit(updateReservationDTO);
        UserDTO usuario = userClient.findUserById(updateReservationDTO.getUserId())
                .orElseThrow(() -> new BookingNotFoundException("USER_NOT_FOUND"));

        SupplierAttentionDTO supplierAttention = serviceClient.findSupplierAttentionById(updateReservationDTO.getSupplierAttentionId())
                .orElseThrow(() -> new BookingNotFoundException("ATTENTION_NOT_FOUND"));

        try {
            location = locationRepository.save(location);

            reservationDB.setComment(updateReservationDTO.getComment());
            reservationDB.setDateRequested(updateReservationDTO.getDateRequested());
            reservationDB.setStatus(StatusOrder.ORDERED);
            reservationDB.setUserId(usuario.getId());
            reservationDB.setLocation(location);
            reservationDB.setSupplierAttentionId(supplierAttention.getId());

            reservationDB = reservationRepository.save(reservationDB);
        } catch (Exception e) {
            throw new BookingInternalErrorException(
                    "Error de base de datos al actualizar el rol"
            );
        }

        return reservationConverter.convertReservationToDTO(reservationDB);
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
