package com.spring.instinctblogs.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	@NotEmpty(message = "Comment cannot be empty")
	@Column(columnDefinition = "TEXT")
	private String content;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Blog blog;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	
}
