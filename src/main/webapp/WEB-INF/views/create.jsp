<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	
	 <form:form method="post" action="/saveBlog" class="createContainer"  modelAttribute="blog">
	 			<span class="success">${unique}</span>
   	 			<h1 style="color: #378258;">Create Blog</h1>
    			<hr>
    			<label>Title</label><br/>
    			<form:input path="title" type="text"  placeholder="Enter Title"/><form:errors path="title"/><br/>
    			<label>Description</label><br/>
    			<form:textarea path="body" type="text"  rows="15" cols="100" placeholder="Enter the description"/><form:errors path="body" /><br/>
    			<input type="submit" value="Create" id="submit" >
    			
	</form:form>
</body>
</html>
