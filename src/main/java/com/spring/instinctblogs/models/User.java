package com.spring.instinctblogs.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@Column(unique = true)
	@Size(min=6,message = "Username should be of more than 6 characters")
	private String username;
	
	
	//@Pattern(regexp = "((?=.*[A-Z]).{6,10})",message = "Password must have one upper case,one lower case and shoould be between 6 and 10 characters")
	
	@NotEmpty(message = "password can not be empty")
	private String password;
	
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;
	
	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;
	
	 @OneToMany(
		        mappedBy = "user",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
		    private List<Comment> comments = new ArrayList<>();
	
	 @OneToMany(
		        mappedBy = "user",
		        cascade = CascadeType.ALL,
		        orphanRemoval = true
		    )
		    private List<Blog> blogs = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String fullName() {
		return getFirstName()+" "+getLastName();
	}
	
}
