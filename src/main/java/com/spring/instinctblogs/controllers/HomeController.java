package com.spring.instinctblogs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String index() {
		System.out.println("In home controller");
		return "login";
	}
	
	
}
