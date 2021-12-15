package com.boot.bookingrestaurantapi.services;

import java.util.List;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.json.CreateRestaurantRest;
import com.boot.bookingrestaurantapi.json.RestaurantRest;

public interface RestaurantService {
	RestaurantRest getRestaurantById(Long restaurantId) throws BookingExceptios;
	public List<RestaurantRest> getRestaurants() throws BookingExceptios;
	String createRestaurant(CreateRestaurantRest createRestaurantRest) throws BookingExceptios;
	String updateRestaurants(CreateRestaurantRest createRestaurantRest,Long restaurantId)throws BookingExceptios;


	
}
