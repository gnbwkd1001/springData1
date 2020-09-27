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
 <label>Top Five Songs:</label> <p></p>
	 <a href="/lookifyMain">Main</a><p></p>
 <table>
  <c:forEach items="${topSongs}" var="topSongs"> 
	  <tr>
	    <td><p><a href="/song/show/${topSongs.id}">${topSongs.title}</a>(★${topSongs.rating}) - ${topSongs.artist}</p></td>
	  </tr>
  </c:forEach>
 </table>
</body>
</html>