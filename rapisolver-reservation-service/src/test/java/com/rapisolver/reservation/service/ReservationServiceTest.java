package com.rapisolver.reservation.service;

import com.rapisolver.reservation.service.exceptions.RapisolverException;
import com.rapisolver.reservation.service.repositories.ReservationRepository;
import com.rapisolver.reservation.service.services.impl.ReservationServiceImpl;
import com.rapisolver.reservation.service.utils.TestDataUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReservationServiceTest {
    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Test
    public void shouldReturnAllReservationWhenGetAllReservationsIsCalled() throws RapisolverException {
        when(reservationRepository.findAll()).thenReturn(TestDataUtils.getMockReservation());
        assertEquals(true, reservationService.findAll() != null);
        verify(reservationRepository).findAll();
    }

    @Test
    public void shouldDeleteReservationWhenDeleteReservationCalled() throws RapisolverException {
        when(reservationRepository.existsById(anyLong())).thenReturn(true);

        reservationService.deleteReservation(1L);
        verify(reservationRepository).deleteById(anyLong());
    }
}
