<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Create an Entity!</h2>
	<a href="/lookifyMain">Main</a><p></p>
	
	<form method="POST" action="/addNewSong">
		<label for="title">Title:</label><br>
		<input type="text" name="title"><br>
		
		<label for="artist">Artist:</label><br>
		<input type="text" name="artist"><br>
		
		<label for="rating">Rating:</label><br>
		<input type="text" name="rating"><br>
		<button>Create Entity</button>	
	</form>
</body>
</html>