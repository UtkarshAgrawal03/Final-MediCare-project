package com.medicare.medserver.controlers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.medserver.modules.Cart;
import com.medicare.medserver.modules.User;
import com.medicare.medserver.repo.UserRepo;
import com.medicare.medserver.services.CartServicImpl;

@RestController
public class CartController {
	@Autowired
	CartServicImpl csi;
	@Autowired
	UserRepo ur;
	@GetMapping("/addtoCart/{pid}")
	@CrossOrigin("*")
	public Cart add(@PathVariable("pid") int pid, Principal prin) {
		
		User user=ur.findbyusername(prin.getName());
		return csi.add(pid,user.getId());
	}
	@GetMapping("/getProducts")
	@CrossOrigin("*")
	public List<Cart> getRespectiveProduct(Principal prin)
	{
		User user=ur.findbyusername(prin.getName());
	return csi.getByuid(user.getId());
	}
	@GetMapping("/deleteFromCart/{cid}")
	@CrossOrigin("*")
	public void deleteFromCart(@PathVariable("cid") int cid)
	{
		
	 csi.delete(cid);
	}

}
