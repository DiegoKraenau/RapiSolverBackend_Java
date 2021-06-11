package com.rapisolver.reservation.service.controllers;

import com.rapisolver.reservation.service.dtos.ReservationRequestDTO;
import com.rapisolver.reservation.service.dtos.ReservationResponseDTO;
import com.rapisolver.reservation.service.dtos.UpdateReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    ReservationService reservationService;

    @GetMapping(value = "/reservation")
    public ResponseEntity<List<ReservationResponseDTO>> getAll(){
        return new ResponseEntity<>(reservationService.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/reservation/{reservationId}")
    public ResponseEntity<List<ReservationResponseDTO>> getByReservationId(@PathVariable Long reservationId){
        return new ResponseEntity<>(reservationService.findById(reservationId), HttpStatus.OK);
    }
    @PostMapping(value = "/reservation")
    public ResponseEntity<ReservationResponseDTO> saveReservation(@RequestBody @Valid ReservationRequestDTO reservation){
        ReservationResponseDTO reservationResponse = reservationService.createReservation(reservation);
        return new ResponseEntity<>(reservationResponse,HttpStatus.CREATED);
    }
    @PutMapping(value = "/reservation/{reservationId}")
    public ResponseEntity<ReservationResponseDTO> updateReservationById(@PathVariable Long reservationId, @RequestBody @Valid UpdateReservationDTO updateReservationDTO){
        ReservationResponseDTO reservationResponseDTO = reservationService.updateReservation(reservationId,updateReservationDTO);
        return new ResponseEntity<>(reservationResponseDTO,HttpStatus.OK);
    }
    @DeleteMapping(value = "/reservation/{reservationId}")
    public ResponseEntity<Void> deleteReservationById(@RequestParam Long reservationId){
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
