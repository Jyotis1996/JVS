<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Delete Records</title>
<script type="text/javascript">
//Disable back button
window.history.forward(1);
	window.onload = function() {
		document.getElementById("frmdelete").submit();
	};
</script>

</head>
<body>
	<s:form action="/deleteDetails" styleId="frmdelete">
		<%
		String categoryType = request.getAttribute("categoryType").toString();
			String[] userValues = null;
				userValues = (String[]) request.getAttribute("UserList");
				for(int i=0;i<userValues.length;i++){
		%>
		<s:hidden property="hiddenValues" value="<%=userValues[i] %>"/>
		<%} %>
		<input type="hidden" name="catType" value="<%=categoryType%>">
	</s:form>
</body>
</html>