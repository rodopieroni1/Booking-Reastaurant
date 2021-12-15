package com.boot.bookingrestaurantapi.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRestaurantRest {	

		@JsonProperty("id")
		private Long id;

		@JsonProperty("name")
		private String name;

		@JsonProperty("addres")
		private String addres;

		@JsonProperty("description")
		private String description;

		@JsonProperty("image")
		private String image;

		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAddres() {
			return addres;
		}

		public void setAddres(String addres) {
			this.addres = addres;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

}
