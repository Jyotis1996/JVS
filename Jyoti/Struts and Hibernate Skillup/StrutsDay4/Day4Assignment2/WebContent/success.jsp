<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserDetails</title>
</head>

<style>
/* for custom scrollbar for webkit browser*/
::-webkit-scrollbar {
	width: 6px;
}

::-webkit-scrollbar-track {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

::-webkit-scrollbar-thumb {
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}
</style>
<script>
	function myFunction() {
		window.location = 'login.jsp';
	}
</script>
<body bgcolor="wheat">
	<s:form method="post" action="LoginAction">
		<center>
			<h1 style="font-size: 25px; margin-left: 100px">User Details</h1>
			<div class="tbl-header">
				<table cellpadding="2" cellspacing="0" border="2" align="center">
					<thead>
						<tr>
							<td>First Name</td>
							<td>Middle Name</td>
							<td>Last Name</td>
							<td>Gender</td>
							<td>Email Id</td>
							<td>DateOfBirth</td>
							<td>Address</td>
						</tr>
						<tr>
							<td><s:property value="objuser.FirstName" /></td>
							<td><s:property value="objuser.MiddleName" /></td>
							<td><s:property value="objuser.LastName" /></td>
							<td><s:property value="objuser.Sex" /></td>
							<td><s:property value="objuser.EmailId" /></td>
							<td><s:property value="objuser.BirthDate" /></td>
							<td><s:property value="objuser.Address" /></td>
						</tr>
						<s:iterator value="list">
							<tr>
								<td><s:property value="FirstName" /></td>
								<td><s:property value="MiddleName" /></td>
								<td><s:property value="LastName" /></td>
								<td><s:property value="Sex" /></td>
								<td><s:property value="EmailId" /></td>
								<td><s:property value="BirthDate" /></td>
								<td><s:property value="Address" /></td>
							</tr>
						</s:iterator>
					</thead>
				</table>
			</div>
			<div class="content">
				<s:form action="loginSuccess" method="post">
					<s:if test="objbean.category == 'admin'">
					</s:if>
				</s:form>
				<center>
					<h3>

						<s:reset value="Logout" theme="simple" action="logOut"
							onclick="location='login.jsp'"></s:reset>
					</h3>
				</center>
			</div>
		</center>
	</s:form>
</body>
</html>