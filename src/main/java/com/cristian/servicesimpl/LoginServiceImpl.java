package com.cristian.servicesimpl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.model.User;
import com.cristian.services.LoginService;
import com.cristian.services.UserService;
import org.slf4j.LoggerFactory;

@Service
public class LoginServiceImpl implements LoginService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);
	
	
	@Autowired
	UserService userService;
	
	 public boolean validateUser(String userid, String password) {
		 User user = null;
		 try {
			 user = this.userService.findUser(userid);
		     if(user == null) {
		    	  LOGGER.warn("User with username: "+userid+" not found");
		     } else {
		    	 return user.getUsername().equals(userid) && user.getPwd().equals(password) ;
		     }
		 }catch(Exception e) {
			 LOGGER.error(e.getMessage());
		 }
	      
	     return false ;
	 }
}
