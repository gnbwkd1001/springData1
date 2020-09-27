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
  color: white !important;
}
</style>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><a href="/dojo">Dojo Information</a></h1>
	
	<table>
	  <tr>
	    <th>Name</th>
	    <th>Age</th>
	  </tr>
	 <c:forEach items="${ninjas}" var="ninja" >
		  <tr>
		    <td>${ninja.name }</td>
		    <td>${ninja.age}</td> 
		    
		  </tr>
	  </c:forEach>
	  
	 </table>
	
</body>
</html>