<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="s"%>
<%@taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Header</title>
</head>
<body>
	<bean:message key="label.search.tableList"/>
	<%
		out.println("</th></tr>");
		out.println("<tr><th class='chkbox'><input type='checkbox' name='checkAll' id='checkAll' class='checkAll'></th><th class='useridstyle'>");%>
		<bean:message key='label.search.userID' />
		<% out.println("</th><th class='namestyle'>");%>
		<bean:message key='label.search.name' />
		<% out.println("</th><th class='categorystyle'>");%><bean:message key='label.search.category' />
		<% out.println("</th><th class='sexstyle'>");%><bean:message key='label.search.sex' /><% out.println("</th><th class='addressstyle'>");%>
		<bean:message key='label.search.address' /><% out.println("</th><th class='emailstyle'>");%><bean:message key='label.search.email' />
</body>
</html>