package com.example.demo.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private String userId;
	
	@Column(name="NAME", length=20)
	private String name;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="ABOUT")
	private String about;
	
	@Transient  //transcient is used to let the spring know that we dont want to send the data to db or want to save the data in db so if we wont write @transcient here then it will give an error even after importing everything as we are not storing the data in db so we have to mention @transcient annotation
	private List<Rating> ratings= new ArrayList<>();
	
	
	
}
