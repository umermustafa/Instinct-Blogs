package com.spring.instinctblogs.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LogoutController {

//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		System.out.println("In logout controller");
//		session.invalidate();
//		
//		return "login";
//	}
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, SessionStatus status) {
		System.out.println("In logout controller");
		HttpSession session=request.getSession();
		status.setComplete();
		session.removeAttribute("login");
		return "login";
	}
}
