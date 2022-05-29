package com.medicare.medserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicare.medserver.modules.User;

import com.medicare.medserver.repo.UserRepo;
@Service
public class UserServiceImpl implements UserService  {
	@Autowired
	private UserRepo ur;

	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User createUser(User user) throws Exception {
		if(ur.findbyusername(user.getUsername())==null)
		{
			user.setRoles("ROLE_USER");
			user.setActive(true);
			ur.save(user);
			return user;
		}
		else {
			throw new Exception("User Already Available");
		}
		
		
	}

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		User user=ur.findbyusername(username);
		return user;
	}

	@Override
	public User deleteUser(int userid) {
		// TODO Auto-generated method stub
		return null;
	}

}
