package com.cristian.servicesimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.model.User;
import com.cristian.repositories.UserRepository;
import com.cristian.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findUser(String username) {
		return userRepo.findByUsername(username);
	}

}
