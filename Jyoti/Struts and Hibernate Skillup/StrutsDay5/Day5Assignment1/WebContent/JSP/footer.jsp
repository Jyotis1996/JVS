<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="s"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String category = request.getAttribute("categoryType").toString();
		if (category.equalsIgnoreCase("admin")) {
	%>
	<s:submit property="register" styleId="register"><bean:message key="button.search.register" /></s:submit>
	<s:submit property="update" styleId="update"><bean:message key="button.search.update" /></s:submit>
	<s:submit property="delete" styleId="delete"><bean:message key="button.search.delete" /></s:submit>
	<s:submit property="details" styleId="details"><bean:message key="button.search.details" /></s:submit>
	<%
		} else if (category.equalsIgnoreCase("user")) {
	%>
	<s:submit property="update" styleId="update"><bean:message key="button.search.update" /></s:submit>
	<s:submit property="details" styleId="details"><bean:message key="button.search.details" /></s:submit>
	<%
		}
	%>
</body>
</html>