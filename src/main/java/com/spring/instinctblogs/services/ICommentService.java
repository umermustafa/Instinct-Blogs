package com.spring.instinctblogs.services;

import java.util.List;

import com.spring.instinctblogs.models.Comment;

public interface ICommentService {
	void createComment(Comment comment);
	void deleteComment(int id);
	List<Comment> getCommentsFromPost(int blogid);
}
