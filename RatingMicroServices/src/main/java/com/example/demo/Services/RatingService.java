package com.example.demo.Services;

import java.util.List;

import com.example.demo.Entity.Rating;

public interface RatingService {

	public Rating rate(Rating rating);
	
	public List<Rating> getAll();
	
	public List<Rating> getByhotelId(String hotelId);
	
	public List<Rating> getByuserId(String userId);
}
