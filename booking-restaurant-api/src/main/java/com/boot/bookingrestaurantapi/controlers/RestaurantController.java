package com.boot.bookingrestaurantapi.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.json.CreateReservationRest;
import com.boot.bookingrestaurantapi.json.CreateRestaurantRest;
import com.boot.bookingrestaurantapi.json.RestaurantRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {
	@Autowired
	RestaurantService restaurantService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurants" + "/{" + "restaurantId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingExceptios {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<List<RestaurantRest>> getRestaurants() throws BookingExceptios {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurants());
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/createRestaurants", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> createRestaurants(@RequestBody CreateRestaurantRest createRestaurantRest)
			throws BookingExceptios {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.createRestaurant(createRestaurantRest));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/updateRestaurants", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> updateRestaurants(@RequestBody CreateRestaurantRest createRestaurantRest,
			@RequestParam Long idRestaurant) throws BookingExceptios {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.updateRestaurants(createRestaurantRest, idRestaurant));
	}

}
