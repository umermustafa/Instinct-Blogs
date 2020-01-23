package com.spring.instinctblogs.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logout(HttpSession session,SessionStatus sessionStatus,HttpServletResponse response,HttpServletRequest request) {
		System.out.println("In logout controller");
		session.invalidate();
		 Cookie[] cookies = request.getCookies();
	        for (Cookie cookie : cookies) {
	            cookie.setMaxAge(0);
	            cookie.setValue(null);
	            cookie.setPath("/");
	            response.addCookie(cookie);
	        }
		return "login";
	}
}
