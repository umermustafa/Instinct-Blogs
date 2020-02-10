package com.spring.instinctblogs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.instinctblogs.models.Blog;
import com.spring.instinctblogs.repository.BlogRepository;

@Service
public class BlogService implements IBlogService{

	@Autowired
	BlogRepository blogRespository;
	
	@Override
	public void createBlog(Blog blog) {
		// TODO Auto-generated method stub
		blogRespository.save(blog);
	}

	@Override
	public void deleteBlog(int id) {
		// TODO Auto-generated method stub
		blogRespository.deleteById(id);
		
	}

	@Override
	public void updateBlog(int id, String title, String body) {
		// TODO Auto-generated method stub
		blogRespository.updateBlog(id, title, body);
		
	}

	@Override
	public List<Blog> showBlogsByUserId(int userId) {
		return blogRespository.showBlogsByUserId(userId);
	}

	@Override
	public List<Blog> showAllBlogs() {
		return blogRespository.showAllBlogs();
	}

	@Override
	public Blog showBLogById(int id) {
		
		return blogRespository.showBlogById(id);
	}

}
