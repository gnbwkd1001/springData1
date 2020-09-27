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
	<h1><a href="/dojo">New Dojo</a></h1>
	<form method="POST" action="/newDojo">
		<label for="dojo">Name:</label><br>
		<input type="text" name="name">
		
		<button>Create</button>	
	</form>
</body>
</html>