package com.boot.bookingrestaurantapi.services;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.json.CreateReservationRest;
import com.boot.bookingrestaurantapi.json.ReservationRest;

public interface ReservationService {
	ReservationRest getReservation(Long reservationId) throws BookingExceptios;
	String createReservation(CreateReservationRest createReservationRest) throws BookingExceptios;
}
