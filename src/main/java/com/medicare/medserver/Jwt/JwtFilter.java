package com.medicare.medserver.Jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.medicare.medserver.Myuds;
@Component
public class JwtFilter extends OncePerRequestFilter{
	@Autowired
	JwtUtils jwtutils;
	@Autowired
	Myuds uds;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		final String header=request.getHeader("Authorization");
		String token=null,username=null;
		
		if(header!=null && header.startsWith("Bearer "))
		{
			token=header.substring(7);
			try {
				username=jwtutils.extractUsername(token);
			}
			catch(Exception e) {
				System.out.println("Invalid token");
			}
			
			
		}
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails ud=this.uds.loadUserByUsername(username);
			if(this.jwtutils.validateToken(token, ud)) {
				UsernamePasswordAuthenticationToken upat=new UsernamePasswordAuthenticationToken(ud ,null ,ud.getAuthorities());
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
			else {
				System.out.println("Token Expired");
			}
			
		}
		else {
			System.out.println("Username Inavlid");		}
		
		filterChain.doFilter(request, response);
		
		
	}

}
