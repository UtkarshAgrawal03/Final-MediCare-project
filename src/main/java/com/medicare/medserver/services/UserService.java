package com.medicare.medserver.services;

import com.medicare.medserver.modules.User;


public interface UserService {
	
	public User createUser(User user) throws Exception ;
	public User getUser(String username) ;
	public User deleteUser(int  userid) ;
	
	
}
