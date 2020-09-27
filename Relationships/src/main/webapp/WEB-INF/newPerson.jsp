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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="/">New Person</a></h1>
	<form method="POST" action="/newPerson">
		<label for="firstName">First Name:</label><br>
		<input type="text" name="firstName"><br>
		
		<button>Register</button>	
	</form>
</body>
</html>