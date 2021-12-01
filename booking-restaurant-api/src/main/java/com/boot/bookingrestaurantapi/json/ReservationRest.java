package com.boot.bookingrestaurantapi.json;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationRest {
	@JsonProperty("restaurantId")
	private Long restaurantId;
	@JsonProperty("locator")
	private String locator;
	@JsonProperty("date")
	private Date date;
	@JsonProperty("person")
	private String person;
	@JsonProperty("turnId")
	private String turnId;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getTurnId() {
		return turnId;
	}

	public void setTurnId(String turnId) {
		this.turnId = turnId;
	}

}
