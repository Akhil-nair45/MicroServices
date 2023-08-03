package com.example.demo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Entity.Hotel;
import com.example.demo.Entity.Rating;
import com.example.demo.Entity.User;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.Repository.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo ur;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Override
	public User saveUser(User user) {
		//generate unique userId
		String randomUserId = UUID.randomUUID().toString();
		user.setUserId(randomUserId);
		return ur.save(user);
	}

	@Override
	public User editUser(User user) {
		return ur.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		
		//implement rating service call: Using restTemplate
		//we can also implement the same we did with the userbyif to fetch the rating in all user we are able too see null in ratings, so we can implement the same thing here to able to see the data
		
		return ur.findAll();
	}

	@Override
	public String deleteUser(String userId) {
		 User u=ur.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given Id is not found on server !!: "+userId));
		 if(u!=null)
		 {
		 ur.delete(u);
		 return "User deleted Successfully!";
		 }
		 return "Some error occured!";
	}



	@Override
	public User findById(String userId) {
		//get user by particular id from the database, so we have now given a variable instead of return directly we are writing return in next line
		 User user = ur.findById(userId).get();
		 //no on finding user by id, we can see that we are not able to see the ratings, as rating service is using some differnet db and its a diifernet project all together so we are using rest template here to get the data of rating while getting the details of user by id
		 //http://localhost:9999/Rating/users/ac05c69f-badf-495c-a7f6-951b46fd6ca1 we want to fetch this from rating using rest template
		  Rating[] ratingsofUser = restTemplate.getForObject("http://RATING-MICROSERVICE/Rating/users/"+user.getUserId(), Rating[].class);
		 logger.info("{}",ratingsofUser);
		 
		 List<Rating> ratings = Arrays.stream(ratingsofUser).toList();
		 
		 List<Rating> ratingList = ratings.stream().map(rating -> {
		  //api call to hotel service to get the hotel
			 //http://localhost:9988/Hotel/f235445b-2996-4945-8554-f4f3d679e3b4
			 ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-MICROSERVICES/Hotel/"+rating.getHotelId(),Hotel.class);
			 Hotel hotel = forEntity.getBody();
			 logger.info("response status coe: {}", forEntity.getStatusCode());
			 
			 
		 //set the hotel to rating
			 rating.setHotel(hotel);
			 
			 
	    //return the rating
			 return rating;
			 
		 }).collect(Collectors.toList());
		 
		 user.setRatings(ratingList);
		 return user;
	}

}
