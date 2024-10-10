package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    // Fetch user by email and handle the case when the user is not found
		User user = repo.findByEmail(email)
		                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

		return new CustomUserDetails(user); // Return a custom UserDetails object
	}
}
