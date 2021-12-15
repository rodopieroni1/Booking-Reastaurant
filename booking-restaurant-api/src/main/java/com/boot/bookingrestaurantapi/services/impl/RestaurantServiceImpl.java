package com.boot.bookingrestaurantapi.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;
import com.boot.bookingrestaurantapi.exceptions.InternalServerErrorException;
import com.boot.bookingrestaurantapi.exceptions.NotFoundException;
import com.boot.bookingrestaurantapi.json.CreateRestaurantRest;
import com.boot.bookingrestaurantapi.json.RestaurantRest;
import com.boot.bookingrestaurantapi.repositories.RestaurantRepository;
import com.boot.bookingrestaurantapi.services.RestaurantService;
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);
	public static final ModelMapper modelMapper = new ModelMapper();

	public String createRestaurant(CreateRestaurantRest createRestaurantRest) throws BookingExceptios {
		final Restaurant restaurant = new Restaurant();
		restaurant.setName(createRestaurantRest.getName());
		restaurant.setAddres(createRestaurantRest.getAddres());
		restaurant.setDescription(createRestaurantRest.getDescription());
		restaurant.setImage(createRestaurantRest.getImage());
		try {
			restaurantRepository.save(restaurant);
		} catch (final Exception e) {
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
		}
		return restaurant.getName();
	}

	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingExceptios {
		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	public List<RestaurantRest> getRestaurants() throws BookingExceptios {
		final List<Restaurant> restaurantEntity = restaurantRepository.findAll();
		return restaurantEntity.stream().map(service -> modelMapper.map(service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(Long restaurantId) throws BookingExceptios {
		return restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new NotFoundException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
	}

	@Override
	public String updateRestaurants(CreateRestaurantRest createRestaurantRest, Long restaurantId)
			throws BookingExceptios {
		LOGGER.info("Inicio metodo Actualizar Alumnos");
		RestaurantRest response = new RestaurantRest();
		List<Restaurant> list = new ArrayList<>();
		try {
			Optional<Restaurant> restaurantGuardado = restaurantRepository.findById(restaurantId);
			if(restaurantGuardado.isPresent()) {
				restaurantGuardado.get().setName(createRestaurantRest.getName());
				restaurantGuardado.get().setAddres(createRestaurantRest.getAddres());
				Restaurant restaurant = restaurantRepository.save(restaurantGuardado.get());
				if(restaurant != null) {
					LOGGER.error("Error en Grabar Restaurante");
				}else {
					LOGGER.error("Restaurant Actualizado");
				}
			}
		}catch(Exception e) {
			
		}
		return null;
	}	
}
