<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="UserInfoStyle.css" />
<title>User Details</title>
</head>
<body style="background-color: #F5DEB3" align="center">
	<div style="background-color: #F5DEB3">
		<h1 style="color: #fff">User Details</h1>
		<s:form action="userInfoOnly" method="post" namespace="/">
			<h3>
				Welcome <i>${sessionScope.username}</i>, you have logged in
				successfully!
			</h3>
			<table border=1 align="center" class='table1'>
				<tr>
					<th>Salutation :</th>
					<td><s:property value="objuser.salutation" /></td>
				</tr>
				<tr>
					<th>First Name :</th>
					<td><s:property value="objuser.FirstName" /></td>
				</tr>
				<tr>
					<th>Middle Name :</th>
					<td><s:property value="objuser.MiddleName" /></td>
				</tr>
				<tr>
					<th>Last Name :</th>
					<td><s:property value="objuser.LastName" /></td>
				</tr>
				<tr>
					<th>Gender :</th>
					<td><s:property value="objuser.Gender" /></td>
				</tr>
				<tr>
					<th>Email :</th>
					<td><s:property value="objuser.EmailId" /></td>
				</tr>
				<tr>
					<th>Date Of Birth :</th>
					<td><s:property value="objuser.birth" /></td>
				</tr>
				<tr>
					<th>Address :</th>
					<td><s:property value="objuser.Address" /></td>
				</tr>
				<tr>
					<th>User Name :</th>
					<td><s:property value="objuser.userid" /></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><s:property value="objuser.password" /></td>
				</tr>
				<tr>
					<th>Interest :</th>
					<td><s:property value="objuser.areaofinterest" /></td>
				</tr>
				<tr>
					<th>Other Interest :</th>
					<td><s:property value="objuser.otherinterest" /></td>
				</tr>
				<tr>
					<th>Category:</th>
					<td><s:property value="objuser.category" /></td>
				</tr>
			</table>
		</s:form>
		<a
			href="http://localhost:8080/WelcomeProject/editaction.action?uname=<s:property value="objuser.userid"/>"
			class="btn btn-success">Edit</a>
	</div>
	<h4 style="float: right"><a href="http://localhost:8080/WelcomeProject/" >Logout</a></h4>
</body>
</html>