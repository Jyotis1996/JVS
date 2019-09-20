<%@taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome User</title>
</head>
<body align="center">
	<h1>
		<s:property value="objbean.message"></s:property>
	</h1>
	<h3>
		Welcome <i>${username}</i>, you have logged in
		successfully!
	</h3>
	<h3>
		<a  href="javascript:history.back()">click here to go back to Home Page</a>
	</h3>
</body>
</html>