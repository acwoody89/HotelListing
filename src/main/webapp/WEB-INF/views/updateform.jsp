<%@ page language="java" contentType="text/html; charset =UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/flatly/bootstrap.min.css" />
<!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>

${test }
<div class="container">
	<h1>Update Person</h1>
	<form action="updateperson" method="post">
	ID: ${id} <br><!-- this value cannot be changed by a user, but they can see it -->
	<input type="hidden" name="id" value="${id}"> <!-- We are using this hidden field to pass the data back to the new controller method to process this form -->
	Name: <input type="text" name="name"><br>
	Location: <input type="text" name="location"><br>
	<input type="submit" value="Submit">
	</form>
</div>
</body>
</html>