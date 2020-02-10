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
	<%@include file="navbar.jsp" %>
<!-- 	<img src="/css/img/home-bg.jpg" alt="Smiley face" align="top" height="700" width="700" style="padding:5px;" style="margin-left:250px">
 -->	
 	<div class="main">
 		<h1>Instinct Blogs</h1>
 		<c:if test="${!empty(blog)}">
 		<h1 style="color: #378258">${blog.title}</h1>
 		<p>${blog.body}</p>
 		 		<a href="/addComment">Add Comment</a>
 		
 		</c:if>
 		<c:if test="${!empty(comments)}">
 			<h2 style="color: #378258">Comments</h2>
 			<ul>
 				<c:forEach var="comment" items="${comments}">
 					<li>
<%--  						<h3 style="display:inline;">${comment.content}</h3>
 --%> 						
 					<p class="comment">${comment.content}</p>
 					<span>Written By: ${comment.user.fullName()}</span>
 					</li>
 				</c:forEach>
 			</ul>
 		</c:if>
 	</div>	
</html>