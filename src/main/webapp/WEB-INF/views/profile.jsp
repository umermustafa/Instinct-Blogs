<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<!-- 	<img src="/css/img/home-bg.jpg" alt="Smiley face" align="top" height="700" width="700" style="padding:5px;" style="margin-left:250px">
 -->	<h1>Instinct Blogs</h1>
 		 <span class="success">${blogCreated}</span>
 		<div>
 			<c:if test="${!empty(blogs)}">
 			<ul>
 				<c:forEach var="blog" items="${blogs}">
 					<li>
 						<h1><a href="/showBlog/${blog.id}">${blog.title}</a></h1>
 						<h3>Author ${blog.user.fullName()}</h3>
 					</li>
 				</c:forEach>	
 			</ul>
 		 </c:if>
 		</div>
</body>
</html>