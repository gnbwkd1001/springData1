<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>domain page</h1>
	<br/>
	<form method="POST" action="/api/books">
		<label for="title">Title:</label><br>
		<input type="text" name="title"><br>
		
		<label for="description">Description:</label><br>
		<input type="text" name="description"><br>
		
		<label for="language">Language:</label><br>
		<input type="text" name="language"><br>
		
		<label for="pages">Pages:</label><br>
		<input type="text" name="pages"><br>
		<button>Create Entity</button>	
	</form>
	<br/>
	<br/>
	<h3>Entities</h3><br>
	<c:forEach items="${books}" var="book">
	    <tr>      
	        <a href="/api/books/${book.id}"><td>${book.title}</td></a><br/>
	    </tr><br>
	</c:forEach>
</body>
</html>