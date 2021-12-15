package com.boot.bookingrestaurantapi.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.DeleteRestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class DeleteRestaurantController {
	
	@Autowired
	DeleteRestaurantService deleteRestaurantService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/deleteRestaurant", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> deleteRestaurant(@RequestParam Long idRestaurant) throws BookingExceptios {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				deleteRestaurantService.deleteRestaurant(idRestaurant));
	}
	

}
