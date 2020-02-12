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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import com.spring.instinctblogs.models.Blog;
import com.spring.instinctblogs.models.Comment;
import com.spring.instinctblogs.models.Login;
import com.spring.instinctblogs.models.User;
import com.spring.instinctblogs.services.IBlogService;
import com.spring.instinctblogs.services.ICommentService;
import com.spring.instinctblogs.services.IUserService;

@Controller
@SessionAttributes("blog")
public class BlogsController {

	@Autowired 
	IBlogService blogService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	ICommentService commentService;

	//Request to create a blog
	
	@GetMapping("/redirectCreate")
	public String redirectBlog(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		if (login==null) {
			return "login";
		}
		return "create";
	}
	
	@GetMapping("/createBlog")
	public String createBlog(HttpServletRequest request, SessionStatus status) {
		System.out.println("In profile controller");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		if (login==null) {
			return "login";
		}
		status.setComplete();
		session.removeAttribute("blog");
		return "redirect:/redirectCreate";
	}

	//Saving a post in database

	@PostMapping("/saveBlog")
	public String saveBlog(@Valid @ModelAttribute("blog")Blog blog,BindingResult result,HttpServletRequest request,Model model) {
		System.out.println("In Blogs Controller");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		if (login==null) {
			return "login";
		}
		if (result.hasErrors()) {
			return "create";
		}
		System.out.println(login.getUsername());
		User user=userService.searchUser(login.getUsername(), login.getPassword());

		if (user==null) {
			return "login";
		}
		blog.setUser(user);
		String a=blog.getBody().replaceAll("\n","<br/>");
		blog.setBody(a);
		try {
			//blogRepository.save(blog);
			blogService.createBlog(blog);
			
		} catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("unique","This title already exists choose another one");
			return "create";
		}




		model.addAttribute("blogCreated","Blog has been created successfully");
		List<Blog> blogs=new ArrayList<Blog>();
//		blogs=blogRepository.showBlogsByUserId(user.getId());
		blogs=blogService.showBlogsByUserId(user.getId());
		model.addAttribute("blogs",blogs);
		return "myblogs";
	}


	// Show all the blogs of the currently logged in user

	@GetMapping("/showBlogs")
	public String showBlogs(HttpServletRequest request,Model model){
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		User user=userService.searchUser(login.getUsername(), login.getPassword());

		if(user==null) {
			return "login";
		}
		List<Blog> blogs=new ArrayList<Blog>();
		blogs=blogService.showBlogsByUserId(user.getId());
		model.addAttribute("blogs",blogs);
		return "myblogs";
	}


	//Show the content of blog

	@GetMapping("/showBlog/{id}")
	public String showBlogById(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		System.out.println("In Blogs Controller,in display method");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		User user=userService.searchUser(login.getUsername(), login.getPassword());


		Blog blog=blogService.showBLogById(id);
		List<Comment> comments=commentService.getCommentsFromPost(blog.getId());

		if (user.getId()==blog.getUser().getId()) {
			model.addAttribute("blog", blog);
			model.addAttribute("comments",comments);
			return "showblog";
		}

		model.addAttribute("blog", blog);
		model.addAttribute("comments",comments);
		return "showBlogFromProfile";
	}
	//Show the content of blog

	@GetMapping("/showBlogFromProfile/{id}")
	public String showBlogFromProfile(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		System.out.println("In Blogs Controller,in display method");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
//		Blog blog=blogRepository.showBlogById(id);
		Blog blog=blogService.showBLogById(id);
		List<Comment> comments=commentService.getCommentsFromPost(blog.getId());

		model.addAttribute("blog", blog);
		model.addAttribute("comments",comments);
		return "showBlogFromProfile";
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
		//blogRepository.deleteById(id);
		blogService.deleteBlog(id);
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
		Blog blog=blogService.showBLogById(id);
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
			blogService.updateBlog(blog.getId(),blog.getTitle(), blog.getBody());
		}
		catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("unique","This title already exists choose another one");
			return "editblog";
		}
		return "redirect:/showBlogs";

	}
}
