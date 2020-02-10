package com.spring.instinctblogs.services;

import com.spring.instinctblogs.models.User;

public interface IUserService {
	void registerUser(User user);
	User searchUser(String username,String password);
}
