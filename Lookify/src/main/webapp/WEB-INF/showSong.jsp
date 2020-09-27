<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/lookifyMain">Main</a><p></p>
	<label>Title           :   ${song.title}</label><p></p>
	<label>Artist          :   ${song.artist}</label><p></p>
	<label>Rating(1-10)    :   ${song.rating}</label><p></p>
	<a href="/song/delete/${song.id}">Delete</a>
</body>
</html>