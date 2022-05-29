package com.medicare.medserver.services;

import java.util.List;

import com.medicare.medserver.modules.Cart;

public interface CartService {
	
	public Cart getByid(int id);
	public Cart add(int pid,int uid);
	public void delete(int id);
	public List<Cart> getByuid(int uid);
	

}
