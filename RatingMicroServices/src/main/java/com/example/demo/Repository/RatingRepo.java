package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, String> {

	List<Rating> findByhotelId(String hotelId);

	List<Rating> findByuserId(String userId);

}
