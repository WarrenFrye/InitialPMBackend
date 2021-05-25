package com.capstone.capstone.service;

import java.util.List;
import java.util.Optional;

import com.capstone.capstone.model.Users;

public interface UserService {

	Optional<Users> findByEmail(String email);
	
	List<Users> findByLastName(String lname);
}
