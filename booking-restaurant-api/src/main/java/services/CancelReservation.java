package services;

import exception.BookingException;

public interface CancelReservation {
	
	public String deletetReservation(String locator) throws BookingException;

}
