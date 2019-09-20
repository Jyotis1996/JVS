<%-- filename:index.jsp
     description: index.jsp contains three functions to add data,display data and clear data
     @author name : Jyoti --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Employee Manager</title>

<script type="text/javascript">
	function display() {
		window.location.replace("display.jsp");
	}
</script>

<link rel="stylesheet" href="css/style2.css">
</head>

<body>

	<div align="center">

		<button id="addBtn" class="button">Add Details</button>

		<button onclick="display()" id="detailsBtn" class="button">Get
			Details</button>

		<form action="ClearEmployeeData" method="get">

			<button type="submit" class="button"
				style="text-decoration: none; display: inline-block;">Clear
				Details</button>

		</form>

		<div align="center" id="simple" class="modal">
			<div align="center" class="modal-content">

				<span class="close">&times;</span>
				<h2>Employee Registration</h2>
				<form method="get" action="welcome">

					<table style="align: center;">
						<tr>
							<td>Name</td>
							<td><input type="text" name="name" required></td>
						</tr>
						<tr>
							<td>Mobile No.</td>
							<td><input type="text" name="mn" pattern="[789][0-9]{9}"
								required></td>
						</tr>
						<tr>
							<td>Role</td>
							<td><input type="text" name="role" required></td>
						</tr>
						<tr>
							<td><input type="submit" value="Submit" class="button"
								style="position: relative; left: 100px; align: center;" /></td>
						</tr>


					</table>

				</form>
			</div>
		</div>
	</div>

	<script src="js/function.js"></script>

</body>
</html>