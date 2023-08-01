package com.example.demo.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Rating;
import com.example.demo.Repository.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService {
	
	@Autowired
	private RatingRepo rr;
	

	@Override
	public Rating rate(Rating rating) {
		String ratingId = UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return rr.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return rr.findAll();
	}

	@Override
	public List<Rating> getByhotelId(String hotelId) {
		return rr.findByhotelId(hotelId);
	}

	@Override
	public List<Rating> getByuserId(String userId) {
		return rr.findByuserId(userId);
	}

}
