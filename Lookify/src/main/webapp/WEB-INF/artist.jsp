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
 <label>Songs by artist: ${searchArtist}</label> 
	<form method="POST" action="/lookify/search">
	 	<input type="text" name="searchArtist">
	 	<button>Search!</button>
	</form>  
	 <a href="/lookifyMain">Main</a><p></p>
 <table>
  <tr>
    <th>Name</th>
    <th>Rating</th>
    <th>Actions</th>
  </tr>
  <c:forEach items="${artistInfo}" var="artistInfo"> 
	  <tr>
	    <td><a href="/song/show/${artistInfo.id}">${artistInfo.title}</a></td>
	    <td>${artistInfo.rating}</td>
	    <td><a href="/song/delete/${artistInfo.id}">Delete</a></td>
	  </tr>
  </c:forEach> 
 </table>
</body>
</html>