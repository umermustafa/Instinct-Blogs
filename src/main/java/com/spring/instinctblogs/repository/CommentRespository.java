package com.spring.instinctblogs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.instinctblogs.models.Comment;

@Repository
public interface CommentRespository extends CrudRepository<Comment, Integer>{

	@Query("select c from Comment c where c.blog.id= :blog_id")
	public  List<Comment> getCommentsFromPost(@Param("blog_id")int blogid);
}
