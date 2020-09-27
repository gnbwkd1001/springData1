<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 6px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
<meta charset="UTF-8">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
</head>
<body>
 <a href="/addNew">Add New </a> <a>  </a><a href="/tops"> Top Songs</a>
 <form method="POST" action="/lookify/search">
 	<input type="text" name="searchArtist">
 	<button>Search!</button>
 </form>  
 
 <table>
  <tr>
    <th>Name</th>
    <th>Rating</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${songs}" var="song">
	  <tr>
	    <td><a href="/song/show/${song.id}">${song.title}</a></td>
	    <td>★${song.rating}</td>
	    <td><a href="/song/delete/${song.id}">Delete</a></td>
	  </tr>
  </c:forEach>
 </table>
</body>
</html>