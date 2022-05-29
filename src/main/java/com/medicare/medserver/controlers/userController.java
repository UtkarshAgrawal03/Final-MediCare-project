package com.medicare.medserver.controlers;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.medserver.modules.Medicines;
import com.medicare.medserver.modules.User;
import com.medicare.medserver.repo.UserRepo;
import com.medicare.medserver.services.MedServiceImpl;
import com.medicare.medserver.services.UserServiceImpl;

@RestController

public class userController {

	
	@Autowired
	private UserServiceImpl us;
	@Autowired
	private MedServiceImpl medimpl;
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/signup")
	public User Signup(@RequestBody User user) throws Exception {
		
		User u=us.createUser(user);
		return u;
	}
//	@GetMapping("/{username}")
//	@CrossOrigin(origins = "http://localhost:3000")
//	@ResponseBody
//	public User View(@PathVariable String username) {
//		return us.getUser(username);
//	}
	@GetMapping("/getAll/{offset}/{size}")
	@CrossOrigin
	public Page<Medicines> getAll(@PathVariable("offset") int o,@PathVariable("size") int s){
		return medimpl.getAllMedicines(o, s);
	}
	@GetMapping("/getAllByField/{offset}/{size}/{field}")
	@CrossOrigin
	public Page<Medicines> getAll(@PathVariable("offset") int o,@PathVariable("size") int s,@PathVariable("field") String f){
		return medimpl.getAllMedicines(o, s,f);
	}
	@GetMapping("/products/{name}")
	@CrossOrigin
	public Medicines getByName(@PathVariable("name") String name){
		return medimpl.getMedicines(name);}
	@GetMapping("/profile")
	@CrossOrigin
	public User getProfile(Principal prin){
		return us.getUser(prin.getName());}
	@GetMapping("/getByid/{id}")
	@CrossOrigin
	public Optional<Medicines> getByid(@PathVariable("id") int id){
		return medimpl.getMedicines(id);
	}
	
}
