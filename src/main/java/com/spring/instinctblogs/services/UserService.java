package com.spring.instinctblogs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.instinctblogs.models.User;
import com.spring.instinctblogs.repository.UserRespository;

@Service
public class UserService implements IUserService{

	@Autowired
	UserRespository userRespository;
	
	@Override
	public void registerUser(User user) {
		userRespository.save(user);
	}

	@Override
	public User searchUser(String username, String password) {
		return userRespository.searchUser(username, password);
	}

}
