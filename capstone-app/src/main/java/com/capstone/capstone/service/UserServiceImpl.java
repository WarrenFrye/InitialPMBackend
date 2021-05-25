package com.capstone.capstone.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone.capstone.model.Users;
import com.capstone.capstone.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public Optional<Users> findByEmail(String email) {
		// TODO Auto-generated method stub
		return repository.findEmail(email);
	}

	@Override
	public List<Users> findByLastName(String lname) {
		// TODO Auto-generated method stub
		return repository.findByLastName(lname);
	}

}
