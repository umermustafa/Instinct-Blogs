<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="/css/navbar.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">
</head>
<body>
	<%@include file="navbar.jsp" %>
	
	 <form:form method="post" action="/updateBlog/${blog.id}" class="createContainer" modelAttribute="blog">
   	 <span class="success">${unique}</span>	
    <h1>Edit Blog</h1>
    <hr>
    			<label>Title</label><br/>
    			<form:input path="title" type="text" value="${blog.title}"/><form:errors path="title"/><br/>
    			<label>Description</label><br/>
    			<form:textarea path="body" type="text" value="${blog.body}" rows="15" cols="100"/><form:errors path="body" /><br/>
    			<input type="submit" value="Edit" id="submit" >
	</form:form>
</body>
</html>