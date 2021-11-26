package services.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import exception.BookingException;
import exception.InternalServerErrorException;
import exception.NotFoundException;
import repositorys.ReservationRepository;
import services.CancelReservation;

public class CancelReservationServiceImpl implements CancelReservation {
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CancelReservationServiceImpl.class);

	@Autowired
	private ReservationRepository reservationRepository;

	public String deletetReservation(String locator) throws BookingException {
		reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFoundException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
		try {
			reservationRepository.deleteByLocator(locator);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}

		return "LOCATOR DELETTE";
	}

}
