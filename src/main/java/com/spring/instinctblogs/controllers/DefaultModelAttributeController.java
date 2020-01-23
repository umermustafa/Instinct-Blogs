package com.spring.instinctblogs.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.instinctblogs.models.Login;
import com.spring.instinctblogs.models.Blog;
import com.spring.instinctblogs.models.User;

@ControllerAdvice
public class DefaultModelAttributeController {

	@ModelAttribute("newuser")
	public User getDefaultUser() {
		return new User();
	}
	
	@ModelAttribute("login")
	public Login getDefaultLogin() {
		return new Login();
	}
	
	@ModelAttribute("blog")
	public Blog getDefaultPost() {
		return new Blog();
	}
	
}
