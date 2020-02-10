package com.spring.instinctblogs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.instinctblogs.models.Comment;
import com.spring.instinctblogs.repository.CommentRespository;

@Service
public class CommentService implements ICommentService{

	@Autowired
	CommentRespository commentRepository;
	
	@Override
	public void createComment(Comment comment) {
		commentRepository.save(comment);
	}

	@Override
	public void deleteComment(int id) {
		// TODO Auto-generated method stub
		commentRepository.deleteById(id);
		
	}

	@Override
	public List<Comment> getCommentsFromPost(int blogid) {
		// TODO Auto-generated method stub
		
		return commentRepository.getCommentsFromPost(blogid);
	}

}
