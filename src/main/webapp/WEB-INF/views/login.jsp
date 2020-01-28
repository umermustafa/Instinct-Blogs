<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Instinct Blogs</title>
<link href="/css/navbar.css" rel="stylesheet">
<link href="/css/style.css" rel="stylesheet">
</head>
<body class="home">
	 <div style="margin-top:150px;">
    	<h1 style="color: #378258;">Instinct Blogs</h1>
	</div>
	 
     <section>
     	<div class="container">
     <form:form method="post" action="/successfull_login"   modelAttribute="newuser">
     <span class="success">${noUser}</span>
		<span class="success">${dataSaved}</span>
    <h1 style="color: #378258;">Login</h1>
    <hr>
   				<form:input path="username" type="text" placeholder="Enter Username"/><form:errors path="username" cssClass="error"/><br/>
    			<form:input path="password" type="password"  placeholder="Enter password"/><form:errors path="password" cssClass="error"/><br/>
    			<input type="submit" value="Login" id="submit" >
	</form:form>
	<a href="/signUp" class="button">Register new user? Click here</a>
	</div>
     </section>
	

</body>
</html>