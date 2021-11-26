package services;

import exception.BookingException;
import jsons.CreateReservationRest;
import jsons.ReservationRest;

public interface ReservationService {
	ReservationRest getReservation(Long reservationId) throws BookingException;
	String createReservation(CreateReservationRest CreateReservationRest) throws BookingException;

}
