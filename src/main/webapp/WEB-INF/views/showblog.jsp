<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Instinct Blogs</title>
<base href="/" />
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
<!-- 	<img src="/css/img/home-bg.jpg" alt="Smiley face" align="top" height="700" width="700" style="padding:5px;" style="margin-left:250px">
 -->	
 		<h1>Instinct Blogs</h1>
 		<c:if test="${!empty(blog)}">
 		<h1 style="color: #378258">${blog.title}</h1>
 		<h4>${blog.body}</h4>
 		</c:if>
</body>
</html>