<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Instinct Blogs</title>
<link href="css/navbar.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>
	
	<%@include file="navbar.jsp" %>
	
	<div class="main">
		<h1>Instinct Blogs</h1>
 		 <span class="success">${blogCreated}</span>
 			<c:if test="${!empty(blogs)}">
 			<div class="listContainer">
 				<c:forEach var="blog" items="${blogs}">
 					<ul>
 						<li>
 							<hr>
 							<h1><a href="/showBlog/${blog.id}">${blog.title}</a></h1>
 							<p style="display:inline;">Author ${blog.user.fullName()}</p>
 							<fmt:parseDate value="${blog.created_at}" pattern="yyyy-MM-dd" var="parsedDate" type="date" />

							<fmt:formatDate value="${parsedDate}" var="newParsedDate" type="date" pattern="MM-dd-yyyy" />
 							<span>${newParsedDate}</span>
 							
 						</li>
 					</ul>	
 				</c:forEach>	
 					</div>
 		 </c:if>
	</div>
 	
</body>
</html>