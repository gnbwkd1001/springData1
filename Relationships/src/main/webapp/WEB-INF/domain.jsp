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
 table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 6px;
  color:white;
}

tr:nth-child(even) {
  background-color: #dddddd;
  color: black !important;
}
</style>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Information</h1>
	<a href="/register/person">Register new Person</a><p></p><a href="/register/license">Register new License</a>
	
	<table>
	  <tr>
	    <th>First Name</th>
	    <th>License#</th>
	    <th>State</th>
	    <th>Expiration Date</th>
	  </tr>
	  <c:forEach items="${people}" var="person">
		  <tr>
		    <td><a href="/person/${person.id}">${person.firstName }</a></td>
		    <td>${person.license.number }</td>
		    <td>${person.license.state }</td>
		    <td>${person.license.expirationDate }</td>
		    
		  </tr>
	  </c:forEach>
	 </table>
	 <c:forEach items="${license}" var="license">
	 <p><a href="/license/${license.id }">${license.number}</a></p>
	 <p>${license.expirationDate}</p>
	 <p>${license.state}</p>
	 </c:forEach>
	 
</body>
</html>