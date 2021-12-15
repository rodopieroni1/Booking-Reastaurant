package com.boot.bookingrestaurantapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan({"com.boot.bookingrestaurantapi"})
public class BookingRestaurantApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingRestaurantApiApplication.class, args);
	}

}
