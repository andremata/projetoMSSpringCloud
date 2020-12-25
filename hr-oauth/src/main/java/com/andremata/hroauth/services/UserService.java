package com.andremata.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andremata.hroauth.entities.User;
import com.andremata.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {
	
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient feignClient;
	
	public User findByEmail(String email) {
		User user = feignClient.findByEmail(email).getBody();
		
		if (user == null) {
			logger.error("Email não encontrado " + email);
			throw new IllegalArgumentException("Email não encontrado!");
		}
		
		logger.info("Email encontrado " + email);
		
		return user;
	}
}
