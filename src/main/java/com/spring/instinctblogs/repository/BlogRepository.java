package com.spring.instinctblogs.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.instinctblogs.models.Blog;
import com.spring.instinctblogs.models.User;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{
	
	/*
	 * @Query("select p from Blog p " + "inner join p.user u " + "on p.user_id=u.id"
	 * + "where p.user_id= :id" ) public List<Blog> showPosts(@Param("id")int
	 * userid);
	 */
	/*
	 * @Query("select b from Blog b where b.id= :id") public Blog
	 * searchBlog(@Param("id")int id);
	 */
	
	@Query("SELECT b FROM Blog b WHERE b.user.id= :id")
	public List<Blog> showBlogsByUserId(@Param("id")int userid);
	
//	@Query("SELECT b FROM Blog b ORDER BY created_at")
//	public List<Blog> showAllBlogs(org.springframework.data.domain.Pageable pageable);
	
	@Query("SELECT b FROM Blog b ORDER BY created_at")
	public List<Blog> showAllBlogs();
	
	@Query("SELECT b FROM Blog b WHERE b.id= :id")
	public Blog showBlogById(@Param("id")int id);
	
	
	@Modifying
	@Transactional
	@Query("UPDATE Blog b SET b.title= :title, b.body= :body WHERE b.id= :id")
	public  void updateBlog(@Param("id")int id,@Param("title")String title,@Param("body")String body);
	
	
	
}
