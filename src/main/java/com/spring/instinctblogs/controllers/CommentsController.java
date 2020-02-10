package com.spring.instinctblogs.controllers;

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
import com.spring.instinctblogs.models.Comment;
import com.spring.instinctblogs.models.Login;
import com.spring.instinctblogs.models.User;
import com.spring.instinctblogs.repository.BlogRepository;
import com.spring.instinctblogs.repository.CommentRespository;
import com.spring.instinctblogs.repository.UserRespository;

@Controller
public class CommentsController {

	@Autowired
	CommentRespository commentRepository;
	
	@Autowired
	UserRespository userRepository;
	
	@Autowired 
	BlogRepository blogRespository;
	
	@GetMapping("/addComment")
	public String addComment(HttpServletRequest request) {
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		if (login==null) {
			return "login";
		}
		return "createComment";
	}
	
	@PostMapping("/saveComment")
	public String saveComment(@Valid @ModelAttribute("comment")Comment comment,BindingResult result,HttpServletRequest request,Model model) {
		System.out.println("In Comments Controller");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		Blog blog=(Blog)session.getAttribute("blog");
		if (login==null || blog==null) {
			return "login";
		}
		if (result.hasErrors()) {
			return "createComment";
		}
		User user=userRepository.searchUser(login.getUsername(), login.getPassword());
		if (user==null) {
			return "login";
		}
		System.out.println(blog.getId());
		comment.setUser(user);
		comment.setBlog(blog);
		commentRepository.save(comment);
		int blogId=blog.getId();
		return "redirect:/showBlog/"+blogId+"";
	}
	
	@GetMapping("/deleteComment/{id}")
	public String deleteBlogById(@PathVariable("id")int id,Model model,HttpServletRequest request) {
		System.out.println("In Comments Controller,in Delete method");
		HttpSession session=request.getSession();
		Login login=(Login)session.getAttribute("login");
		System.out.println("In blogs controller,showall blogs ,methods"); 
		if (login==null) {
			return "login";
		}
		Blog blog=(Blog)session.getAttribute("blog");
		commentRepository.deleteById(id);
		return "redirect:/showBlog/"+blog.getId()+"";
	}
	
	
}
