package com.example.HelloWorld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")	
public class HelloWorldController {

	@GetMapping("/hello")
	public String helloworld() {
		return "Hello World";
	}
}
