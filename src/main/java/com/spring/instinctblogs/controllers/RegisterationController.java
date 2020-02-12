package com.spring.instinctblogs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.instinctblogs.models.User;
import com.spring.instinctblogs.services.IUserService;

@Controller
public class RegisterationController {

	@Autowired
	IUserService userService; 	
	@GetMapping("/signUp")
	public String welcome() {
		System.out.println("In home controller");
		return "signup";
	}
	
	@PostMapping("/registeruser")
	public String registerUser(@Valid @ModelAttribute("newuser") User user,BindingResult result,Model model) {
		 System.out.println("In registration controller");
		 if (result.hasErrors()) {
			return "signup";
		}
		 try {
			 userService.registerUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("unique","Username already exist,try another one.");
			return "signup";
		}
		
		 model.addAttribute("dataSaved", "User Registered Successfully");
		 return "login";
	}
}
