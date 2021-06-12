package com.rapisolver.reservation.service.util;

import com.rapisolver.reservation.service.dtos.CreateReservationDTO;
import com.rapisolver.reservation.service.dtos.UpdateReservationDTO;
import com.rapisolver.reservation.service.entities.Location;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocationConverter {
    @Autowired
    private ModelMapper modelMapper;

    public CreateReservationDTO convertLocationToDto(Location location) {
        return modelMapper.map(location, CreateReservationDTO.class);
    }

    public Location convertLocationToEntity(CreateReservationDTO createReservationDTO) {
        return modelMapper.map(createReservationDTO, Location.class);
    }

    public Location convertLocationToEntityEdit(UpdateReservationDTO updateReservationDTO) {
        return modelMapper.map(updateReservationDTO, Location.class);
    }
}