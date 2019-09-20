<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Success</title>
</head>
<body bgcolor="wheat">

	<s:label>Hello User :  <%=request.getParameter("username")%></s:label>
	<h1>You are Successfully Login ....</h1>
	<h3>

		<s:reset value="Logout" theme="simple" action="logOut"
			onclick="location='login.jsp'"></s:reset>
	</h3>
</body>
</html>