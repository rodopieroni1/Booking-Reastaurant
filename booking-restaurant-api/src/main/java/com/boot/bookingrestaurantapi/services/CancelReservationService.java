package com.boot.bookingrestaurantapi.services;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;

public interface CancelReservationService {
	public String deleteReservation(String locator) throws BookingExceptios;
}
