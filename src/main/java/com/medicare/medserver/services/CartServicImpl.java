package com.medicare.medserver.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.medicare.medserver.modules.Cart;
import com.medicare.medserver.modules.Medicines;
import com.medicare.medserver.repo.CartRepo;
@Service
public class CartServicImpl implements CartService {
	
	@Autowired
	CartRepo cr;
	

	@Override
	public Cart getByid(int id) {
		// TODO Auto-generated method stub
		return cr.getById(id);
	}

	@Override
	public Cart add(int pid, int uid) {
		// TODO Auto-generated method stub
		if(cr.userandproductid(uid, pid)==null)
		{
			Cart cart=new Cart();
			cart.setProductId(pid);
			cart.setUserId(uid);
			cart.setQuantity(1);
			
			return cr.save(cart);
		}
		else {
			System.out.println("CArt value Allready present");
		}
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}
	
	public Page<Cart> getAllProduct(int offset,int pagesize) {
		return cr.findAll(PageRequest.of(offset,pagesize));

		
	}

	
	
	@Override
	public List<Cart> getByuid(int uid) {
		// TODO Auto-generated method stub
		
		return cr.findByUserid(uid);
	}

}
