package com.andremata.hroauth.services;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.andremata.hroauth.entities.User;
import com.andremata.hroauth.feignclients.UserFeignClient;

@Service
public class UserService implements UserDetailsService {
	
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = feignClient.findByEmail(username).getBody();
		
		if (user == null) {
			logger.error("Email não encontrado " + username);
			throw new UsernameNotFoundException("Email não encontrado!");
		}
		
		logger.info("Email encontrado " + username);
		
		return user;
	}
}
