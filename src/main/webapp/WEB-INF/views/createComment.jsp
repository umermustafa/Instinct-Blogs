<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Instinct Blogs</title>
<link href="css/navbar.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div class="topnav">
  		<a class="active" href="/userprofile">Home</a>
  		<a href="/createBlog">Create Blog</a>
  		<a href="/showBlogs">My Blogs</a>
  		<a href="/logout">Logout</a>	
	</div>
	<form:form method="post" action="/saveComment" class="createContainer" modelAttribute="comment">
		<h1 style="color: #378258;">Add Comment</h1>
		<br>
		<label>Comment</label>
		<form:textarea path="content" type="text" rows="8" placeholder="Enter Comment"/><form:errors path="content"/><br/>
		<input type="submit" value="Add" id="submit" >
	</form:form>	

</body>
</html>