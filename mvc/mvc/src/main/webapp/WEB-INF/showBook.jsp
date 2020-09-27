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
	<h1>Show Entity Page</h1> 
	<a href="/">back to main</a>
	<br/>
	<br/>
	<label>Title:</label>
	<p>${book.title}</p>
	<label>Description:</label>
	<p>${book.description}</p>
	<label>Language:</label>
	<p>${book.language}</p>
	<label>Pages:</label>
	<p>${book.numberOfPages}</p>
	<a href="/edit/${book.id}">Edit Entity</a>
	<form action="/books/${book.id}" method="post">
	    <input type="hidden" name="_method" value="delete">
	    <input type="submit" value="Delete Entity">
	</form>
</html>