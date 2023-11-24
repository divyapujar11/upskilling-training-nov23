package com.cg.authenticateuser.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.authenticateuser.model.ApplicationUser;

@RestController
@RequestMapping("/api")
public class AuthenticationController {
	
	@PostMapping("/authenticate")
	public String authenticate(@RequestBody ApplicationUser user) {
		System.out.println("received: " +user.getUsername());
		
		if("user".equals(user.getUsername()) && "password".equals(user.getPassword())){
			return "Valid User";
		}
		else {
			return "Invalid User";
		}
	}

}
