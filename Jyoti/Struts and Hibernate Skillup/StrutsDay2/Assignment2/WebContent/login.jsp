<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style type="text/css">
.errorMessage,.actionMessage {
	color: #b30000;
}

.error li {
	list-style: none;
}

.error {
	background-color: #ffb3b3;
	border: 1px solid #CC0000;
}
</style>
</head>
<body bgcolor="wheat">
	<s:form method="post" action="LoginAction">
		<table  align="center"
			style="margin-left: 450px; margin-top: 200px; border-width: 2px; background-color: #d9d9d9; padding-left: 100px; padding-right: 80px; padding-top: 30px; padding-bottom: 30px ">

			<tr>
				<td colspan="2">
					<h1 style="font-size: 25px; margin-left: 100px">Login</h1>
				</td>
			</tr>
			<tr>

				<td colspan="2">
					<div class="error">
						<s:actionerror />
					</div>
				</td>

			</tr>
			<tr>
				<td><s:textfield label="User Name " name="objbean.username" placeholder="Enter Username"/></td>
			</tr>
			<tr>
				<td><s:password label="Password " name="objbean.password"  placeholder="Enter Password"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><s:submit value="Login"
						theme="simple"></s:submit> <s:reset value="Clear" theme="simple"
						onclick="location='login.jsp'"></s:reset></td>
		</table>

	</s:form>
</body>
</html>