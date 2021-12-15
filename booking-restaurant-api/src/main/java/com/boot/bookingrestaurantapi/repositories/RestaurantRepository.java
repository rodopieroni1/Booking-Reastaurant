package com.boot.bookingrestaurantapi.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boot.bookingrestaurantapi.entities.Reservation;
import com.boot.bookingrestaurantapi.entities.Restaurant;
import com.boot.bookingrestaurantapi.exceptions.BookingExceptios;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	
	Optional<Restaurant> findById(Long id);
	Optional<Restaurant> findByName(String nameRestaurant);
	@Query("SELECT REST  FROM Restaurant REST")
	public List<Restaurant> findRestaurant();
	@Modifying
	@Transactional
	Optional<Restaurant> deleteRestaurantById(Long restaurantId);
}
