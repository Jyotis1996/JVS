<%@page import="com.assignment1.bean.UserListBean"%>
<%@page import="com.assignment1.bean.UserDataBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/struts-html" prefix="s"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Details</title>
<link rel="stylesheet" type="text/css" href="styleUserInfo.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.min.js"></script>
<script type="text/javascript">
	//Disable back button
	window.history.forward(1);
	$(function() {
		$('#update').attr("disabled", true);
		$('#details').attr("disabled", true);
		$('#delete').attr("disabled", true);

		// add multiple select / deselect functionality
		$("#checkAll").click(function() {
			$('.check_box').attr('checked', this.checked);
		});

		// if all checkbox are selected, check the selectall checkbox
		// and viceversa
		$(".check_box").change(function() {

			if ($(".check_box").length == $(".check_box:checked").length) {
				$("#checkAll").attr("checked", "checked");
			} else {
				$("#checkAll").removeAttr("checked");
			}
			if ($(".check_box:checked").length > 1) {
				$('#update').attr("disabled", true);
				$('#details').attr("disabled", true);
				$('#register').attr("disabled", true);

			} else {
				$('#delete').attr("disabled", false);
				$('#update').attr("disabled", false);
				$('#details').attr("disabled", false);
				$('#register').attr("disabled", false);
			}
			if ($(".check_box:checked").length == 0) {
				$('#update').attr("disabled", true);
				$('#details').attr("disabled", true);
				$('#delete').attr("disabled", true);
				$('#register').attr("disabled", false);
			} else {
				$('#delete').attr("disabled", false);
				$('#register').attr("disabled", true);
			}
		});

		$(".checkAll").change(function() {
			if ($(".checkAll:checked").length > 0) {
				$('#update').attr("disabled", true);
				$('#details').attr("disabled", true);
				$('#register').attr("disabled", true);
				$('#delete').attr("disabled", false);
			} else {
				$('#update').attr("disabled", true);
				$('#details').attr("disabled", true);
				$('#register').attr("disabled", false);
				$('#delete').attr("disabled", true);
			}
		});

	});
	function logout() {
		var backlen = history.length;
		history.go(-backlen);
		window.location.replace("http://localhost:8080/Day5Assignment1/");
	}
</script>
</head>
<body bgcolor=wheat style='border: 1px solid #900; padding-left: 10px;'>

	<s:form action="SearchAction">

		<div id="searchDesign" align="right">
			<h2 align="left">
				<u><bean:message key="label.search.userListScreen" /></u>
			</h2>
			<a href='javascript:logout()'> <bean:message
					key="link.search.logout" />
			</a>
		</div>
		<%
			String category = request.getAttribute("categoryType").toString();
				if (!category.equalsIgnoreCase("user")) {
		%>
		<div id="searchDiv" class="searchDiv">
			<h3>
				<u><bean:message key="label.search.searchCriteria" /></u>
			</h3>

			<table>
				<tr>
					<th><bean:message key="label.login.userID" /></th>
					<td><s:text property="userName" styleId="userId" /></td>
					<th><bean:message key="label.search.category" /></th>
					<td><s:select property="category" styleId="category"
							style="width: 100%">
							<s:option value="">---</s:option>
							<s:option value="admin">
								<bean:message key='label.search.admin' />
							</s:option>
							<s:option value="user">
								<bean:message key='label.search.user' />
							</s:option>
						</s:select></td>
				</tr>
				<tr>
					<th><bean:message key="label.search.name" /></th>
					<td><s:text property="firstName" styleId="name" /></td>
					<th><bean:message key="label.search.address" /></th>
					<td><s:text property="address" styleId="address" /></td>
				</tr>
				<tr>
					<th><bean:message key="label.search.sex" /></th>
					<td><s:select property="gender" styleId="sex"
							style="width: 100%">
							<s:option value="">---</s:option>
							<s:option value="male">
								<bean:message key='label.update.male' />
							</s:option>
							<s:option value="female">
								<bean:message key='label.update.female' />
							</s:option>
						</s:select></td>
					<th><bean:message key="label.search.email" /></th>
					<td><s:text property="email" styleId="email" /></td>
				</tr>
			</table>
			<br>
			<s:submit property="submitSearch">
				<bean:message key="button.search.search" />
			</s:submit>
			<s:reset property="reset" onclick="location='http://localhost:8080/Day5Assignment1/userList.do'">
				<bean:message key="button.search.clear" />
			</s:reset>
			<br> <br>
		</div>
		<%
			}
		%>
	</s:form>

	<div id="dataTable"
		style="<%if ((request.getAttribute("categoryType").toString()).equalsIgnoreCase("admin")) {
				if (request.getParameter("submitSearch") != null)
					out.println("display:block");
				else
					out.println("display:none");
			}%>">

		<s:form action="/operation" method="post">
			<%
				response.setContentType("text/html");
					ArrayList<?> objArrayList = null;
					UserListBean objUserListBean = null;
					String category = "";
					objUserListBean = new UserListBean();
					category = request.getAttribute("categoryType").toString();
			%>
			<table border=1 align='center' class='flat-table'>
				<%
					objArrayList = (ArrayList<?>) request.getAttribute("UserList");
						if (objArrayList.size() > 0) {
				%>
				<tr>
					<th colspan='7'>
						<div id="header">
							<jsp:include page="/JSP/header.jsp"></jsp:include>
						</div>
					</th>
				</tr>
				<%
					if (category.equalsIgnoreCase("admin")) {

								objArrayList = (ArrayList<?>) request.getAttribute("UserList");
								for (int i = 0; i < objArrayList.size(); i++) {
									objUserListBean = (UserListBean) objArrayList.get(i);
				%>

				<tr>
					<td height='15px'><input type='checkbox' name='check_box'
						class='check_box' value="<%=objUserListBean.getUserName()%>">
					</td>
					<td><%=objUserListBean.getUserName()%></td>
					<td><%=objUserListBean.getSalutation()%> <%=objUserListBean.getFirstName()%>
						<%=objUserListBean.getMiddleInitial()%> <%=objUserListBean.getLastName()%>
					</td>
					<td><%=objUserListBean.getCategory()%></td>
					<td><%=objUserListBean.getGender()%></td>
					<td><%=objUserListBean.getAddress()%></td>
					<td><%=objUserListBean.getEmail()%></td>
				</tr>
				<%
					}
				%>
				<tr style="display: none">
					<td><input type="hidden" name="catType" value="admin"></td>
				</tr>
				<%
					}
							if (category.equalsIgnoreCase("user")) {

								objArrayList = (ArrayList<?>) request.getAttribute("UserList");
								for (int i = 0; i < objArrayList.size(); i++) {
									objUserListBean = (UserListBean) objArrayList.get(i);
				%>
				<tr>
					<td height='15px'><input type='checkbox' name='check_box'
						class='check_box' value="<%=objUserListBean.getUserName()%>">
					</td>
					<td><%=objUserListBean.getUserName()%></td>
					<td><%=objUserListBean.getSalutation()%> <%=objUserListBean.getFirstName()%>
						<%=objUserListBean.getMiddleInitial()%> <%=objUserListBean.getLastName()%>
					</td>
					<td><%=objUserListBean.getCategory()%></td>
					<td><%=objUserListBean.getGender()%></td>
					<td><%=objUserListBean.getAddress()%></td>
					<td><%=objUserListBean.getEmail()%></td>
				</tr>
				<tr style="display: none">
					<td><input type="hidden" name="catType" value="user">
					</td>
				</tr>
				<%
					}
							}
				%>
				<tr>
					<th colspan='7' align='right'>
						<div id="footer">
							<jsp:include page="/JSP/footer.jsp"></jsp:include>
						</div>
					</th>
				</tr>
				<%
					} else {
				%>
				<tr style="display: none">
					<td><input type="hidden" name="catType" value="admin"></td>
				</tr>
				<tr>
					<th colspan='7'>
						<div id="header">
							<bean:message key="label.search.tableList" />
							<%
								out.println("</th></tr>");
										out.println("<tr><th><input type='checkbox'></th><th>");
							%>
							<bean:message key='label.search.userID' />
							<%
								out.println("</th><th>");
							%><bean:message key='label.search.name' />
							<%
								out.println("</th><th>");
							%><bean:message
								key='label.search.category' />
							<%
								out.println("</th><th>");
							%><bean:message key='label.search.sex' />
							<%
								out.println("</th><th>");
							%><bean:message
								key='label.search.address' />
							<%
								out.println("</th><th>");
							%><bean:message
								key='label.search.email' />
						</div>
					</th>
				</tr>
				<tr>
					<td colspan='7'><bean:message
							key="label.search.noRecordsFound" /></td>
				</tr>
				<tr>
					<th colspan='7' align='right'>
						<div id="footer">
							<jsp:include page="/JSP/footer.jsp"></jsp:include>
						</div>
					</th>
				</tr>
				<%
					}
				%>
			</table>

		</s:form>
	</div>
</body>
</html>