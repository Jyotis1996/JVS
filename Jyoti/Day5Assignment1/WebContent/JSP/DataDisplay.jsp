<%@page import="java.util.ArrayList"%>
<%@page import="com.assignment1.bean.UserListBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//Disable back button
	window.history.forward(1);
</script>
</head>
<body>
	<s:form action="/abc" method="post">
		<%
			response.setContentType("text/html");
				ArrayList<?> objArrayList = null;
				UserListBean objUserListBean = null;
				String category = "";
				try {
					objUserListBean = new UserListBean();
					out.println(" <table border=1 align='center' class='flat-table' >");
		%>
		<div id="header">
			<jsp:include page="/JSP/header.jsp"></jsp:include>
		</div>
		<%
			category = request.getAttribute("categoryType").toString();
					if (category.equalsIgnoreCase("admin")) {
						objArrayList = (ArrayList<?>) request.getAttribute("UserList");
						for (int i = 0; i < objArrayList.size(); i++) {
							objUserListBean = (UserListBean) objArrayList.get(i);
							out.println(
									"<tr><td height='15px'><input type='checkbox' name='check_box' class='check_box'></td><td>");
							out.println(objUserListBean.getUserName());
							out.println("</td><td>");
							out.println(objUserListBean.getSalutation() + " " + objUserListBean.getFirstName() + " "
									+ objUserListBean.getMiddleInitial() + " " + objUserListBean.getLastName());
							out.println("</td><td>");
							out.println(objUserListBean.getCategory());
							out.println("</td><td>");
							out.println(objUserListBean.getGender());
							out.println("</td><td>");
							out.println(objUserListBean.getAddress());
							out.println("</td><td>");
							out.println(objUserListBean.getEmail());
							out.println("</td></tr>");

						}
					}
					if (category.equalsIgnoreCase("user")) {
						objUserListBean = (UserListBean) request.getAttribute("UserList");
						out.println(
								"<tr><td height='15px'><input type='checkbox' name='check_box' class='check_box'></td><td>");
						out.println(objUserListBean.getUserName());
						out.println("</td><td>");
						out.println(objUserListBean.getSalutation() + ". " + objUserListBean.getFirstName() + " "
								+ objUserListBean.getMiddleInitial() + " " + objUserListBean.getLastName());
						out.println("</td><td>");
						out.println(objUserListBean.getCategory());
						out.println("</td><td>");
						out.println(objUserListBean.getGender());
						out.println("</td><td>");
						out.println(objUserListBean.getAddress());
						out.println("</td><td>");
						out.println(objUserListBean.getEmail());
						out.println("</td></tr>");
					}
		%>
		<div id="footer">
			<jsp:include page="/JSP/footer.jsp"></jsp:include>
		</div>
		<%
			out.println("</table>");
				} catch (Exception e) {
					e.printStackTrace();
				}
		%>
	</s:form>
</body>
</html>