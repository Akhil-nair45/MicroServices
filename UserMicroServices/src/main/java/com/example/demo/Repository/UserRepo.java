package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.User;

public interface UserRepo extends JpaRepository<User, String> {

	Optional<User> findById(String userId);

}
