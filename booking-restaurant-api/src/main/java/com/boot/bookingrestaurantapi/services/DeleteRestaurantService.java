package com.boot.bookingrestaurantapi.services;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;

public interface DeleteRestaurantService {
	public String deleteRestaurant(Long idRestaurant) throws BookingExceptios;
}
