package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Rating;
import com.example.demo.Services.RatingService;

@RestController
@RequestMapping("/Rating")
public class RatingController {

	
	@Autowired
	private RatingService rs;
	
	@PostMapping("/rate")
	public ResponseEntity<?> rate(@RequestBody Rating rating)
	{
		return new ResponseEntity<>(rs.rate(rating),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getALl()
	{
		return new ResponseEntity<>(rs.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<?> getByHotelId(@PathVariable String hotelId)
	{
		return new ResponseEntity<>(rs.getByhotelId(hotelId),HttpStatus.OK);
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<?> getByUserId(@PathVariable String userId)
	{
		return new ResponseEntity<>(rs.getByuserId(userId),HttpStatus.OK);
	}
}
