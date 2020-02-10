package com.spring.instinctblogs.services;

import java.util.List;

import com.spring.instinctblogs.models.Blog;

public interface IBlogService {
	void createBlog(Blog blog);
	void deleteBlog(int id);
	void updateBlog(int id,String title,String body);
	List<Blog> showBlogsByUserId(int userId);
	List<Blog> showAllBlogs();
	Blog showBLogById(int id);
	
}
