package com.medicare.medserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.medicare.medserver.Jwt.JwtFilter;
import com.medicare.medserver.Jwt.UnauthHandler;


@Configuration
@EnableWebSecurity
public class AppsecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	Myuds uds;
	@Autowired
	UnauthHandler unauthHandler;
	@Autowired
	JwtFilter jwtfilter;
	
 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(uds);
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/generate-token","/signup","/med","/getAll/{offset}/{size}","/").permitAll()
		.antMatchers(HttpMethod.OPTIONS).permitAll()
		.anyRequest().authenticated()
		
		.and()
		.exceptionHandling().authenticationEntryPoint(unauthHandler)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		 http.cors().and().csrf().disable();
		 
		 http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	}
	@Bean
	public PasswordEncoder getPaswordEncoder()
	{
		return  NoOpPasswordEncoder.getInstance();
	}
     @Override
     @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
    	// TODO Auto-generated method stub
    	return super.authenticationManager();
    }

}
