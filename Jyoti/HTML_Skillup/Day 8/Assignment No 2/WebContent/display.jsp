<%-- file name:display.jsp
     description: this file helps to display data from local storage on the basis of the name as id
     @author Jyoti --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>

<link rel="stylesheet" href="css/style2.css">
</head>
<body>
	<div class="container" align="center">

		<form method="get" action="DisplayEmployeeData" style="align: center;">
			<h1 align="center">Employee Details</h1>
			Name<input type="text" name="name1"> <input class="button"
				type="submit" value="Search"> <br> <br> <br>
			<input type=button class=button onClick="parent.location='index.jsp'"
				value='click here go to home page'>

		</form>
	</div>
</body>

</html>