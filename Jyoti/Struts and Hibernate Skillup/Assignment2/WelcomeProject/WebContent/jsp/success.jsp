<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body style="background-color: #F5DEB3">
	<div class="well">
		<s:form action="userInfo" method="post" namespace="/">
			<!-- <h1 style="color: #fff">Successfully Login</h1> -->
			<h3>
				Welcome <i>${sessionScope.username}</i>, you have logged in
				successfully!
			</h3>
			<h3 style="float: right">
				<a href="http://localhost:8080/WelcomeProject/">Logout</a>
			</h3>

			<table>
				<tr>
					<td>First Name:<s:property value="objuser.FirstName" /></td>
				</tr>
				<tr>
					<td>Middle Name:<s:property value="objuser.MiddleName" /></td>
				</tr>
				<tr>
					<td>Last Name:<s:property value="objuser.LastName" /></td>
				</tr>
				<tr>
					<td>Gender:<s:property value="objuser.Gender" /></td>
				</tr>
				<tr>
					<td>Email:<s:property value="objuser.EmailId" /></td>
				</tr>
				<tr>
					<td>Address:<s:property value="objuser.Address" /></td>
				</tr>
			</table>

			<br />
			<s:submit class="btn btn-success" align="left" />
		</s:form>
	</div>
</body>
</html>