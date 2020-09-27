<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
 body {background-color: black;}
 h1 {color: white;}
 a{color: white;}
 p{color:white;}
 label{color:white;}
</style>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="/">New License</a></h1>
	<form method="POST" action="/newLicense">
		<label for="person">Person:</label><br>
		<select name="person">
			<c:forEach items="${people}" var="person">
				<option>${person.id}</option>
			</c:forEach>
		</select>
		<br>
		<label for="state">State:</label><br>
		<input type="text" name="state"><br>
		
		<label for="date">Expiration Date:</label><br>
		<input type="date" name="date">
		
		<button>Register</button>	
	</form>
</body>
</html>