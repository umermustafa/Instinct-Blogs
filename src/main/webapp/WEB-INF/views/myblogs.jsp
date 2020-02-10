<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<meta charset="ISO-8859-1">
<title>Instinct Blogs</title>
<link href="css/navbar.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<%@include file="navbar.jsp" %>
<!-- 	<img src="/css/img/home-bg.jpg" alt="Smiley face" align="top" height="700" width="700" style="padding:5px;" style="margin-left:250px">
 -->
 <div class="main">
	 <div>
	 	<h1>Instinct Blogs</h1>
 		 <span class="success">${blogCreated}</span>
	 </div>		
 		
 		
 		<c:if test="${!empty(blogs)}">
 			<ul>
 				<c:forEach var="blog" items="${blogs}">
 				  
 				 <li>
 					<hr>
 					<h1 style="display:inline;"><a href="/showBlog/${blog.id}">${blog.title}</a></h1>
 					<div style="float:right">
 						<form:form method="post" action="/deleteBlog/${blog.id}" >
 							<input type="submit" value="Delete" id="submit">
 						</form:form>
 					</div>
 					<div style="float:right"> 
 						<form:form method="get" action="/editBlog/${blog.id}" >
 							<input type="submit" value="Edit" id="submit">
 						</form:form>
 					</div>
 				 </li>
 				  		
 				</c:forEach>	
 					<hr>
 			</ul>
 		
 		 </c:if>
 		 </div>
</body>
</html>