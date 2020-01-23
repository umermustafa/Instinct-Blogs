package com.spring.instinctblogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.spring.instinctblogs.models.Blog;
import com.spring.instinctblogs.models.Login;
import com.spring.instinctblogs.models.User;
import com.spring.instinctblogs.repository.BlogRepository;
import com.spring.instinctblogs.repository.UserRespository;

@Controller
public class BlogsController {

	
	@Autowired
	BlogRepository blogRepository;

	@Autowired
	UserRespository userRepository;


	//Saving a post in database
	
	@PostMapping("/saveBlog")
	public String saveBlog(@Valid @ModelAttribute("blog")Blog blog,BindingResult result,@SessionAttribute("login")Login login,Model model) {
		System.out.println("In Blogs Controller");
		if (result.hasErrors()) {
			return "create";
		}
		System.out.println(login.getUsername());
		User user=userRepository.searchUser(login.getUsername(), login.getPassword());
		if (user==null) {
			return "login";
		}
		blog.setUser(user);
		String a=blog.getBody().replaceAll("\n","<br/>");
		blog.setBody(a);
		try {
			blogRepository.save(blog);
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("unique","This title already exists choose another one");
			return "create";
		}
		
		
	
		
		model.addAttribute("blogCreated","Blog has been created successfully");
		List<Blog> blogs=new ArrayList<Blog>();
		blogs=blogRepository.showBlogsByUserId(user.getId());
		model.addAttribute("blogs",blogs);
		return "myblogs";
	}


	// Show all the blogs of the currently logged in user
	
	@GetMapping("/showBlogs")
	public String showBlogs(/* @SessionAttribute("login")Login login, */HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		User user=userRepository.searchUser(login.getUsername(), login.getPassword());
		if(user==null) {
			return "login";
		}
		List<Blog> blogs=new ArrayList<Blog>();
		blogs=blogRepository.showBlogsByUserId(user.getId());
		model.addAttribute("blogs",blogs);
		return "myblogs";
	}
	
	
	//Show all the blogs of currently logged in User
	
	@GetMapping("/showBlog/{id}")
	public String showBlogById(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		System.out.println("In Blogs Controller,in display method");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		Blog blog=blogRepository.showBlogById(id);
		model.addAttribute("blog", blog);
		return "showblog";
	}
	
	// Delete a selected blog
	
	@PostMapping("/deleteBlog/{id}")
	public String deleteBlogById(@PathVariable("id")int id,Model model,HttpServletRequest request) {
		System.out.println("In Blogs Controller,in Delete method");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		blogRepository.deleteById(id);
		return "redirect:/showBlogs";
	}
	
	// Edit a slected blog
	
	@GetMapping("/editBlog/{id}")
	public String editBlogById(@PathVariable("id")int id,Model model,HttpServletRequest request) {
		System.out.println("In Edit Function");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		Blog blog=blogRepository.showBlogById(id);
		String a=blog.getBody().replaceAll("<br/>","\n");
		blog.setBody(a);
		model.addAttribute("blog", blog);
		return "editblog";
	}
	
	@PostMapping("/updateBlog/{id}")
	public String updateBlog(@Valid @ModelAttribute("blog")Blog blog,BindingResult result ,@PathVariable("id")int id,Model model,HttpServletRequest request) {
		System.out.println("In Update method of blogs controller");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		if (result.hasErrors()) {
			return "editblog";
		}
		
		
		String a=blog.getBody().replaceAll("\n","<br/>");
		blog.setBody(a);
		try {
			blogRepository.updateBlog(blog.getId(), blog.getTitle(), blog.getBody());
			
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("unique","This title already exists choose another one");
			//return "redirect:/editBlog/{id}";
			return "editblog";
		}
		return "redirect:/showBlogs";
		
	}
	
	
	
	
	
}
