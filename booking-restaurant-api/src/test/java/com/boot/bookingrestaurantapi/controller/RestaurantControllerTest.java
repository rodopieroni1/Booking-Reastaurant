package com.boot.bookingrestaurantapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import com.boot.bookingrestaurantapi.controlers.RestaurantController;
import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.json.RestaurantRest;
import com.boot.bookingrestaurantapi.json.TurnRest;
import com.boot.bookingrestaurantapi.responses.BookingResponse;
import com.boot.bookingrestaurantapi.services.RestaurantService;

public class RestaurantControllerTest {
	private static final Long RESTAURANT_ID = 1L;
	private static final String NAME = "Burger King";
	private static final String DESCRIPTION = "Burger King, EL CAPO DE LAS HAMBURGUESAS";
	private static final String ADDRESS = "Av. Galindo";
	private static final String IMAGE = "www.image.com";
	private static final String SUCCES_STATUS = "Succes";
	private static final String SUCCES_CODE = "200 OK";
	private static final String OK = "OK";
	public static final List<TurnRest> TURN_LIST = new ArrayList<>();
	public static final RestaurantRest RESTAURANT_REST = new RestaurantRest();

	@Mock
	RestaurantService restaurantService;
	@InjectMocks
	RestaurantController restaurantController;	
	@BeforeEach
	public void init() throws BookingExceptios {
		MockitoAnnotations.initMocks(this);
		RESTAURANT_REST.setName(NAME);
		RESTAURANT_REST.setDescription(DESCRIPTION);
		RESTAURANT_REST.setAddres(ADDRESS);
		RESTAURANT_REST.setId(RESTAURANT_ID);
		RESTAURANT_REST.setImage(IMAGE);
		RESTAURANT_REST.setTurns(TURN_LIST);

		Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);
	}

	@Test
	public void getRestaurantByIdTest() throws BookingExceptios {
		final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), RESTAURANT_REST);
	}

}
