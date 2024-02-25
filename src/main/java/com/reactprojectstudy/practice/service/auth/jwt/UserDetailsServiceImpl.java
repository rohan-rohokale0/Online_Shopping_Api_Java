package com.reactprojectstudy.practice.service.auth.jwt;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.reactprojectstudy.practice.enitity.User;
import com.reactprojectstudy.practice.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

	private final UserRepository userRepository;
	
	public UserDetailsServiceImpl(UserRepository userRepository) {
		
		this.userRepository = userRepository;
	}

	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

	        //Write Logic to get the user from the DB
	        User user = userRepository.findFirstByEmail(email);
	        if(user == null){
	            throw new UsernameNotFoundException("User not found",null);
	        }
	        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	    }

}
