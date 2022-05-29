package com.medicare.medserver.Jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicare.medserver.Myuds;

@RestController
public class AuthControler {

	@Autowired
	AuthenticationManager am;
	@Autowired
	Myuds ud;
	@Autowired
	JwtUtils jwtutils;
	
	@PostMapping("/generate-token")
	@CrossOrigin("*")
	public ResponseEntity<?> generatetoken(@RequestBody JwtRequest jwtrequest) throws Exception{
		try {
			authenticate(jwtrequest.getUsername(),jwtrequest.getPassword());
		
		}
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			System.out.println("Username not found");
		}
		
		UserDetails userdetail=ud.loadUserByUsername(jwtrequest.getUsername());
		String token=jwtutils.generateToken(userdetail);
		return ResponseEntity.ok( new JwtResponse(token));
		
	}
	 
	public void authenticate(String username,String password) throws Exception
	
	{
		try{
			am.authenticate(new UsernamePasswordAuthenticationToken(username,password));
		}
		catch(Exception e) {
			throw new Exception("User Unauthenticatd");
		}
		
	}
}
