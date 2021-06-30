package com.rapisolver.reservation.service.utils;

import com.rapisolver.reservation.service.entities.Location;
import com.rapisolver.reservation.service.entities.Reservation;
import com.rapisolver.reservation.service.enums.StatusOrder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestDataUtils {
    public static List<Reservation> getMockReservation(){
        List<Reservation> reservations = new ArrayList<>();

        Reservation reservation01 = Reservation.builder()
                .id(1L)
                .comment("Coment of this video is about called..")
                .dateRequested(new Date())
                .status(StatusOrder.DELIVERED)
                .location(Location.builder().id(2L).address("Av. republica").city("Lima").country("Peru").state("example").build()).supplierAttentionId(1L)
                .build();

        Reservation reservation02 = Reservation.builder()
                .id(2L)
                .comment("Coment of this video is about called vidio02..")
                .dateRequested(new Date())
                .status(StatusOrder.DELIVERED)
                .location(Location.builder().id(1L).address("Av. city lima").city("Lima").country("Peru").state("example").build()).supplierAttentionId(2L)
                .build();

        Reservation reservation03 = Reservation.builder()
                .id(3L)
                .comment("Coment of this video is about called..")
                .dateRequested(new Date())
                .status(StatusOrder.DELIVERED)
                .location(Location.builder().id(3L).address("Av. juarez").city("Trujillo").country("Peru").state("example").build()).supplierAttentionId(3L)
                .build();

        reservations.add(reservation01);
        reservations.add(reservation02);
        reservations.add(reservation03);

        return reservations;
    }
}
