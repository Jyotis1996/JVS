<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<center>

		<s:form action="Welcome">
			<table align="center">
				<tr><h4>
					<font color="red"> <s:property value="objbean.message"></s:property></font>
				</h4></tr>
				<tr><h2>Hello</h2></tr>
				<tr>
					<td><s:textfield name="objbean.username" label="Username"
							placeholder="Enter Username" class="form-control" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><s:submit value="Submit"
							theme="simple"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:reset
							value="reset" onclick="location='index.jsp'" theme="simple"></s:reset></td>
				</tr>
			</table>
		</s:form>
	</center>
</body>
</html>