<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="../day3/UserList.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body style="background-color: #F5DEB3">
	<div class="main container">
		<h3 style="float: left">
			<s:property value="getText('user.ADD')" />
		</h3>
		<h3 style="float: right">
			<a href="http://localhost:8080/WelcomeProject/jsp/Userlist.jsp"><s:property
					value="getText('user.USERLISTSCREEN')" /></a>
		</h3>
	</div>
</body>
</html>