package com.spring.instinctblogs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.instinctblogs.models.User;

@Repository
public interface UserRespository extends JpaRepository<User, Integer>{

//	@Query("select u from User u where u.username=: name and u.password=: pass")
//	public User searchUser(@Param("name")String username,@Param("pass")String password);
	@Query("select u from User u where u.username= :name and u.password= :pass")
	public User searchUser(@Param("name")String username,@Param("pass")String password);
}
