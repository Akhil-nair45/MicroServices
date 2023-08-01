package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import com.example.demo.Service.UserServiceImpl;

@RestController
@RequestMapping("/Users")
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user){
		return new ResponseEntity<>(us.saveUser(user),HttpStatus.CREATED);
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editUser(@RequestBody User user){
		return new ResponseEntity<>(us.editUser(user),HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllUser(){
		return new ResponseEntity<>(us.getAllUser(),HttpStatus.OK);
	}
	
	@GetMapping("{userId}")  // here i found an error while writting the endpoint as find/id it wont work even find/userId wont work u must only have to pass userId or what type of id u have written u have to pass that so this is the new error which i got
	public ResponseEntity<?> getUserById(@PathVariable String userId) {
		return new ResponseEntity<>(us.findById(userId),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable String userId){
		return new ResponseEntity<>(us.deleteUser(userId),HttpStatus.OK);
	}
}
