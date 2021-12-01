package com.boot.bookingrestaurantapi.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.json.RestaurantRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;

@RestController
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;

	public BookingResponse<RestaurantRest> getRestaurantById(Long restaurantId) throws BookingExceptios{

		return new BookingResponse<>("Secces", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}

}
