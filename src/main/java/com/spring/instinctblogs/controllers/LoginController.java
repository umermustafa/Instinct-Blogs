package com.spring.instinctblogs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.spring.instinctblogs.models.Login;
import com.spring.instinctblogs.models.User;
import com.spring.instinctblogs.repository.UserRespository;

@Controller
@SessionAttributes("login")
public class LoginController {

	@Autowired
	UserRespository userRespository;
	
	@GetMapping("/goToLogin")
	public String goToLogin() {
		return "login";
	}
	
	@PostMapping("/successfull_login")
	public String login(@ModelAttribute("login") Login login,Model model)  {
		User user=userRespository.searchUser(login.getUsername(),login.getPassword());
		if (user==null) {
			model.addAttribute("noUser","Wrong Username or password");
			return "login";
		}
		return "forward:/userprofile";
	}
}
