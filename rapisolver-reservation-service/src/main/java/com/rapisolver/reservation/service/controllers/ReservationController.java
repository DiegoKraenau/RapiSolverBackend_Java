package com.rapisolver.reservation.service.controllers;

import com.rapisolver.reservation.service.dtos.*;
import com.rapisolver.reservation.service.exceptions.RapisolverException;
import com.rapisolver.reservation.service.response.RapisolverResponse;
import com.rapisolver.reservation.service.services.ReservationService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @ApiOperation(value = "Get All Reservations", notes = "None")
    @GetMapping(value = "/reservation")
    public RapisolverResponse<List<ReservationDTO>> getAll(){
        List<ReservationDTO> reservationDTOS;
        try {
            reservationDTOS = reservationService.findAll();
        } catch (RapisolverException e) {
            return new RapisolverResponse<>(
                    e.getCode(),
                    e.getStatus(),
                    e.getMessage()
            );
        }
        return new RapisolverResponse<>(
                200,
                "OK",
                "Lista de reservas",
                reservationDTOS
        );
    }

    @ApiOperation(value = "Get Reservation", notes = "None")
    @GetMapping("/reservation/{reservationId}")
    private RapisolverResponse<ReservationDTO> getByReservationId(
            @PathVariable Long reservationId
    ) {
        ReservationDTO reservationDTO;
        try {
            reservationDTO = reservationService.findById(reservationId);
        } catch (RapisolverException e) {
            return new RapisolverResponse<>(
                    e.getCode(),
                    e.getStatus(),
                    e.getMessage()
            );
        }
        return new RapisolverResponse<>(
                200,
                "OK",
                "Reservacion encontrada",
                reservationDTO
        );
    }

    @ApiOperation(value = "Create a Reservation", notes = "None")
    @PostMapping("/createReservation")
    public RapisolverResponse<ReservationDTO> saveReservation(@RequestBody @Valid CreateReservationDTO createReservationDTO) throws RapisolverException {
        ReservationDTO  reservation = reservationService.createReservation(createReservationDTO);
        return new RapisolverResponse<>(200, "OK", "OK",reservation);
    }

    @ApiOperation(value = "Update a Reservation", notes = "None")
    @PutMapping("/reservation/{reservationId}")
    private RapisolverResponse<ReservationDTO> updateReservationById(
            @PathVariable Long reservationId,
            @RequestBody @Valid UpdateReservationDTO updateReservationDTO
    ) {
        ReservationDTO reservationDTO;
        try {
            reservationDTO =
                    reservationService.updateReservation(
                            reservationId,
                            updateReservationDTO
                    );
        } catch (RapisolverException e) {
            return new RapisolverResponse<>(
                    e.getCode(),
                    e.getStatus(),
                    e.getMessage()
            );
        }

        return new RapisolverResponse<>(
                200,
                "OK",
                "Reservacion actualizada correctamente",
                reservationDTO
        );
    }

    @ApiOperation(value = "Delete a Reservation", notes = "None")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/reservation/{reservationId}")
    public RapisolverResponse<ReservationDTO> deleteReservation(@RequestParam Long reservationId) throws RapisolverException {
        ReservationDTO reservationDTO;
        reservationDTO = reservationService.findById(reservationId);
        reservationService.deleteReservation(reservationId);
        return new RapisolverResponse<>(200, "OK", "Reservacion borrada correctamente", reservationDTO
        );
    }
}
