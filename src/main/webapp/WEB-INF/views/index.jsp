<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hibernate Demo</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/journal/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>

	<div class=container>
		<h1>Search For People</h1>

		<form action="search">

			ID: <input type="text" name="personid"> <br> <input
				type="submit" value="Search">
		</form>

		<!-- this is for thte add person form -->
		<h1>Add a Person</h1>
		<form action="add" method="post">
			Name:<input type="text" name="name"> <br> Location: <input
				type="text" name="location"> <br> <input type="submit"
				value="add">
		</form>
		<table border="1">
			<c:forEach var="person" items="${list}">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
					<td>${person.location}</td>
					<td><a href="update?id=${person.id}">Update</a></td>
					<td><a href="delete?id=${person.id}">Delete</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
</body>
</html>