package services;

import java.util.List;

import exception.BookingException;
import jsons.RestaurantRest;


public interface RestauranService {

	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
	public List<RestaurantRest> getRestaurants() throws BookingException;
}
