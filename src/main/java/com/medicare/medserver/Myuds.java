package com.medicare.medserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.medicare.medserver.modules.User;
import com.medicare.medserver.repo.UserRepo;

@Service
public class Myuds implements UserDetailsService{
	@Autowired
	UserRepo ur;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=ur.findbyusername(username);
		return  new MyUserDetails(user);
		 	}

}
