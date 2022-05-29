package com.medicare.medserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedserverApplication.class, args);
		System.out.println("I\'m Working");
	}

}
