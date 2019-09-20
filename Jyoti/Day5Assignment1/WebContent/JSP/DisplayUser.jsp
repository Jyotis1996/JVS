<%@page import="com.assignment1.bean.UserListBean"%>
<%@page import="com.assignment1.bean.UserDataBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
<link rel="stylesheet" type="text/css" href="JSP/UserInfoStyle.css">
<script type="text/javascript">
	// Disable back button
	window.history.forward(1);
	function logout() {
		var backlen = history.length;
		history.go(-backlen);
		window.location.replace("http://localhost:8080/Day5Assignment1/");
	}
</script>
</head>
<body>
	<%
		ArrayList<UserListBean> objArrayList = new ArrayList<UserListBean>();
		UserListBean objUserListBean = null;
		try {
			objUserListBean = new UserListBean();

			objUserListBean = (UserListBean) request
					.getAttribute("displayList");

			out.println("<body bgcolor=wheat><h1 style='font-family:MV Boli;margin-left:580px;'>");
	%><bean:message key="label.display.userdetails" />
	<%
		out.println("</h1> <table border=1 align='center' class='table1'> <tr> <th>");
	%><bean:message
		key="label.display.salutation" />
	<%
		out.println(":</th><td>" + objUserListBean.getSalutation());
			out.println("</td></tr><th>");
	%><bean:message
		key="label.display.firstname" />
	<%
		out.println(" :</th><td>" + objUserListBean.getFirstName());
			out.println("</td></tr><th>");
	%><bean:message
		key="label.display.middleinitial" />
	<%
		out.println(" :</th><td>" + objUserListBean.getMiddleInitial());
			out.println("</td></tr><th>");
	%><bean:message
		key="label.display.lastname" />
	<%
		out.println(" :</th><td>" + objUserListBean.getLastName());
			out.println("</td></tr><th>");
	%><bean:message key="label.display.sex" />
	<%
		out.println(" :</th><td>" + objUserListBean.getGender());
			out.println("</td></tr><th>");
	%><bean:message
		key="label.display.email" />
	<%
		out.println(" :</th><td>" + objUserListBean.getEmail());
			out.println("</td></tr><th>");
	%><bean:message
		key="label.display.birthdate" />
	<%
		out.println(" : </th><td>" + objUserListBean.getBirthDate()
					+ "/" + objUserListBean.getBirthMonth() + "/"
					+ objUserListBean.getBirthYear());
			out.println("</td></tr><th>");
	%><bean:message
		key="label.display.address" />
	<%
		out.println(" :</th><td>" + objUserListBean.getAddress());
			out.println("</td></tr><th>");
	%><bean:message
		key="label.display.userid" />
	<%
		out.println(" :</th><td>" + objUserListBean.getUserName());
			out.println("</td></tr><th> ");
	%><bean:message
		key="label.display.password" />
	<%
		out.println(" :</th><td>" + objUserListBean.getPassword());
			out.println("</td></tr><th> ");
	%><bean:message
		key="label.display.areaofinterest" />
	<%
		out.println(" :</th><td>" + objUserListBean.getAreaOfInterest());
			out.println("</td></tr><th> ");
	%><bean:message
		key="label.display.otherinterest" />
	<%
		out.println(" :</th><td>" + objUserListBean.getOtherInterest());
			out.println("</td></tr>");
			out.println("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	<div
		style="padding-bottom: 50px; padding-top: 50px; padding-left: 580px">
		<a href="http://localhost:8080/Struts1_Skillup/userList.do"><bean:message
				key="link.display.back" /></a> &nbsp;&nbsp;&nbsp;&nbsp; <a
			href="javascript:logout()"><bean:message
				key="link.display.logout" /></a>
	</div>
</body>
</html>