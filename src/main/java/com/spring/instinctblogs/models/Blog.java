package com.spring.instinctblogs.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(unique = true)
	@NotEmpty(message = "Title cannot be empty")
	private String title;
	
	@NotEmpty(message = "Description cannot be empty")
	@Column(columnDefinition = "TEXT")
	private String body;
	
	
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
    private User user;
	
	
	 @OneToMany(
		        mappedBy = "blog",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
		    private List<Comment> comments = new ArrayList<>();
	 
	 @DateTimeFormat(pattern="dd/MM/yyyy")
	 @CreationTimestamp
	 private LocalDateTime created_at;
	 
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	 
	 
}
