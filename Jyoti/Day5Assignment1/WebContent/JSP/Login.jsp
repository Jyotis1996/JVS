<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="s"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UYF-8">
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
		<div align="right">
			<s:link page="/Locale.do?method=english">English</s:link>
			<s:link page="/Locale.do?method=japanese">Japanese</s:link>
		</div>
		<table
			style="margin-left: 450px; margin-top: 200px; border-width: 2px; background-color: #d9d9d9; padding-left: 80px; padding-right: 80px; padding-top: 30px; padding-bottom: 30px">

			<tr>
				<td colspan="2">
					<h1 style="font-size: 25px; margin-left: 100px">
						<bean:message key="label.login" />
					</h1>
				</td>
			</tr>
			<tr>

				<td colspan="2">
					<div class="error">
						<s:errors property="error_msg" />
					</div>
				</td>

			</tr>
			<tr>
				<td><bean:message key="label.login.userID" /> :</td>
				<td><s:text property="userName"></s:text></td>
				<td><div class="errorMessage">
						<s:errors property="userName_error" />
					</div></td>
			</tr>
			<tr>
				<td><bean:message key="label.login.password" /> :</td>
				<td><s:password property="password" /></td>
				<td><div class="errorMessage">
						<s:errors property="password_error" />
					</div></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><s:submit><bean:message key="button.login.login" /></s:submit>
					<s:reset property="reset"  onclick="location='http://localhost:8080/Day5Assignment1/'"><bean:message key="button.login.clear" /></s:reset></td>
			</tr>
		</table>

	</s:form>
</body>
</html>