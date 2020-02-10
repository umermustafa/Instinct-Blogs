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
	<%@include file="navbar.jsp" %>
	<form:form method="post" action="/saveComment" class="createContainer" modelAttribute="comment">
		<h1>Add Comment</h1>
		<br>
		<label>Comment</label>
		<form:textarea path="content" type="text" rows="8" placeholder="Enter Comment"/><form:errors path="content"/><br/>
		<input type="submit" value="Add" id="submit" >
	</form:form>	

</body>
</html>