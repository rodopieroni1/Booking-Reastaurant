package com.boot.bookingrestaurantapi.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.services.DeleteRestaurantService;

@Service
public class DeleteRestaurantServiceImpl implements DeleteRestaurantService{
	
	private static  final Logger LOGGER = LoggerFactory.getLogger( DeleteRestaurantServiceImpl.class);
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public String deleteRestaurant(Long idRestaurant) throws BookingExceptios {
		restaurantRepository.findById(idRestaurant)
				.orElseThrow(() -> new NotFoundException("RESTAURANT_NOT_FOUND", "RESTAURANT_NOT_FOUND"));
		try {
			restaurantRepository.deleteRestaurantById(idRestaurant);
		} catch (Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return "RESTAURANT_DELETTE";
	}
}
