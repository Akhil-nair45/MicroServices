package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//we are not going to store this in db as we are using microservices for this rating

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

	private String ratingId;
	private String userId;
	private String hotelId;
	private int rating;
	private String feedback;
	
	private Hotel hotel;
	
}
