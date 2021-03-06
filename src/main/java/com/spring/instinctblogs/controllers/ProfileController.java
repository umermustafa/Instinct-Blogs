package com.spring.instinctblogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.instinctblogs.models.Blog;
import com.spring.instinctblogs.models.Login;
import com.spring.instinctblogs.models.User;
import com.spring.instinctblogs.services.IBlogService;
import com.spring.instinctblogs.services.IUserService;

@Controller
public class ProfileController {

	@Autowired
	IBlogService blogService;
	
	@Autowired
	IUserService userService;
	
	List<Blog> blogs=new ArrayList<Blog>();
	
	@PostMapping("/userprofile")
	public String postProfile(Model model,HttpServletRequest request) {
		System.out.println("In profile controller");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		if (login==null) {
			return "login";
		}
		User user=userService.searchUser(login.getUsername(),login.getPassword());
		if (user==null) {
			return "login";
		}
		System.out.println(login.getUsername());	
		blogs=blogService.showAllBlogs();
		model.addAttribute("blogs",blogs);
		return "redirect:/userprofile";
	}
	
	@GetMapping("/userprofile")
	public String getProfile(Model model,HttpServletRequest request){
		System.out.println("In get mapping of user profile");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		if (login==null) {
			return "login";
		}
		blogs=blogService.showAllBlogs();
		model.addAttribute("blogs",blogs);
		return "profile";
	}
}
