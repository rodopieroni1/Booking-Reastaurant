package services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import entityes.Reservation;
import entityes.Restaurant;
import entityes.Turn;
import exception.BookingException;
import exception.InternalServerErrorException;
import exception.NotFoundException;
import jsons.CreateReservationRest;
import jsons.ReservationRest;
import repositorys.ReservationRepository;
import repositorys.RestaurantRepository;
import repositorys.TurnRepository;
import services.ReservationService;

public class ReservationServiceImpl implements ReservationService {

	private static final Logger LOGGER  =  org.slf4j.LoggerFactory.getLogger(ReservationServiceImpl.class);
			
	@Autowired
	private RestaurantRepository restaurantRepository;
	@Autowired
	private TurnRepository turnRepository;
	@Autowired
	private ReservationRepository reservationRepository;    

	public static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public ReservationRest getReservation(Long reservationId) throws BookingException {
		return modelMapper.map(getReservation(reservationId), ReservationRest.class);
	}

	public List<ReservationRest> getReservations() throws BookingException {
		final List<Reservation> reservationsEntity = reservationRepository.findAll();
		return reservationsEntity.stream().map(service -> modelMapper.map(service, ReservationRest.class))
				.collect(Collectors.toList());
	}

	@Override
	public String createReservation(CreateReservationRest CreateReservationRest) throws BookingException {
		
		final Restaurant restauranId = restaurantRepository.findById(CreateReservationRest.getRestaurantId())
				.orElseThrow(()->new NotFoundException("RESTAURANT_NOT_FOUND","RESTAURANT_NOT_FOUND"));
		
		final Turn turId = turnRepository.findById(CreateReservationRest.getTurnId())
				.orElseThrow(()->new NotFoundException("TURN_NOT_FOUND","TURN_NOT_FOUND"));
		
		String locator = generateLocator(restauranId, CreateReservationRest);
		
		final Reservation reservation = new Reservation();
		reservation.setLocator(locator);
		reservation.setDate(CreateReservationRest.getDate());
		reservation.setPerson(CreateReservationRest.getPerson());
		reservation.setRestaurant(restauranId);
		reservation.setTurn(turId.getName());
		try {
			reservationRepository.save(reservation);
			
		} catch (Exception e) {
		 LOGGER.error("INTERNAL_SERVER_ERROR", e);
		 throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return locator;
	}

	private String generateLocator(Restaurant restaurantId, CreateReservationRest createReservationRest)
			throws BookingException {
		return restaurantId.getName() + createReservationRest.getTurnId();
	}

}
