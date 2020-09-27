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
	<a href="/register/dojo">Register new Dojo</a><p></p><a href="/register/ninja">Register new Ninja</a>
	
	<table>
	  <tr>
	    <th>Dojo Name</th>
	    <th>Ninja Count</th>
	  </tr>
	  <c:forEach items="${dojo}" var="dojo" >
		  <tr>
		    <td><a href="/dojo/${dojo.id}">${dojo.name }</a></td>
		    <td>${dojo.ninjas.size()}</td> 
		    
		  </tr>
	  </c:forEach>
	  <%-- <c:forEach items="${ninja}" var="ninja" >
	  	<p>********</p>
	  	<p>${ninja.name}</p>
	  	<p>${ninja.dojo.name}</p>
	  	<p>********</p>
	  </c:forEach> --%>
	  
	 </table>
	<%-- <p>${ninja.name}</p>
	 <p>${ninja.age}</p>
	 <p>${ninja.dojo.name}</p> --%>
</body>
</html>