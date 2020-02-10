<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/navbar.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body class="home">
	 <div style="margin-top:20px;margin-left:1030px">
    	<h1 style="color: #378258;">Instinct Blogs</h1>
	</div>
<!-- 	<img src="/css/img/home.jpg" alt="Smiley face" height="700" width="700" align="left">
 -->	 
	
	<div class="container">
     <form:form method="post" action="/registeruser" modelAttribute="newuser">
    <h1 style="color: #378258;right:50px;margin-bottom:0px">Sign Up</h1>
	 			<span class="success">${unique}</span>
    
    <p>Please fill in this form to create an account.</p>
    <hr>
   				<form:input path="username" type="text" placeholder="Enter Username"/><form:errors path="username" cssClass="error"/><br/>
    			<form:input path="password" type="password"  placeholder="Enter password"/><form:errors path="password" cssClass="error"/><br/>
    			<form:input path="firstName" type="text"  placeholder="Enter First Name"/><form:errors path="firstName" cssClass="error"/><br/>
    			<form:input path="lastName" type="text"  placeholder="Enter Last Name"/><form:errors path="lastName" cssClass="error"/><br/>
    			<input type="submit" value="Sign Up" id="submit" >
	</form:form>
	<a href="/" class="button">Already Registered? Click here</a>
    </div>

</body>
</html>