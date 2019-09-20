<%@ page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link href="../day3/UserList.css" rel="stylesheet"> -->
<meta http-equiv="Content-Type" charset="UTF-8">

<script type="text/javascript">
	function checkAll() {
		var all = document.getElementById('selectall');
		checkboxes = document.getElementsByName('check[]');
		if (all.checked) {
			for (var i = 0; i < checkboxes.length; i++)
				checkboxes[i].checked = true;
		} else {
			for (var i = 0; i < checkboxes.length; i++)
				checkboxes[i].checked = false;
		}
		operation();
	}
	function operation() {
		var ubtn = document.getElementById('update');
		var dbtn = document.getElementById('detail');
		checkboxes = document.getElementsByName('check[]');
		var checked;
		var count = 0;
		for (var i = 0; i < checkboxes.length; i++) {
			if (checkboxes[i].checked) {
				checked = checkboxes[i];
				count++;
			}
		}
		//alert(checked.value);
		ubtn.href = '/WelcomeProject/editaction.action?uname=' + checked.value;
		dbtn.href = '/WelcomeProject/detailaction.action?uname='
				+ checked.value;

		if (count > 1) {
			ubtn.disabled = true;
			dbtn.disabled = true;

		} else {
			ubtn.disabled = false;
			dbtn.disabled = false;
		}

	}
	function disable() {
		var ubtn = document.getElementById('update');
		var dbtn = document.getElementById('detail');
		if (ubtn.disabled || dbtn.disabled) {
			alert("please select only one user for this procedure");
		}
	}

	function userArray() {
		checkbox = document.getElementsByName('check[]');

		var check = [];
		for (var i = 0; i < checkbox.length; i++) {
			if (checkbox[i].checked) {
				check.push(checkbox[i].value);
			}
		}
		alert(check);
		document.getElementById('uids').value = check;
		return true;
	}
</script>
<title>User List</title>
</head>
<body style="background-color: #F5DEB3">
	<s:if test="hasActionErrors()">
		<div class="errors">
			<s:actionerror />
		</div>
	</s:if>
	<div class="main container">
		<h1 align="left">
			<s:property value="getText('user.USERLISTSCREEN')" />
		</h1>
		<h3 style="float: right">
			<a href="http://localhost:8080/WelcomeProject/"><s:property
					value="getText('user.LOGOUT')" /></a>
		</h3>
		<div class="search">
			<h3>
				<s:property value="getText('user.SEARCHCRITERIA')" />
			</h3>
			<s:form action="userlistaction" method="post" namespace="/">
				<table>
					<tr>
						<td><label><s:property value="getText('user.USERID')" /></label></td>
						<td><input class="" type="text" name="uname" /></td>
						<td><label><s:property
									value="getText('user.CATEGORY')" /></label></td>
						<td><select name="category"><option>---</option>
								<option value="admin">Admin</option>
								<option value="user">User</option></select></td>
					</tr>
					<tr>
						<td><label><s:property value="getText('user.NAME')" /></label></td>
						<td><input type="text" name="fname" /></td>
						<td><label><s:property
									value="getText('user.ADDRESS')" /></label></td>
						<td><input type="text" name="address" /></td>
					</tr>
					<tr>
						<td><label><s:property value="getText('user.SEX')" /></label></td>
						<td><select name="sex"><option>---</option>
								<option value="male">Male</option>
								<option value="female">Female</option></select></td>
						<td><label><s:property value="getText('user.E-MAIL')" /></label></td>
						<td><input type="email" name="email" /></td>
					</tr>
					<tr>
						<td><input type="submit"
							value="<s:property value = "getText('user.SEARCH')" />"
							class="btn btn-success" name="submit" /></td>
						<td><input type="reset"
							value="<s:property value = "getText('user.CLEAR')" />"
							class="btn btn-success" name="reset" /></td>
					</tr>
				</table>
			</s:form>
		</div>
		<div class="tablelist">
			<h3>
				<s:property value="getText('user.TABLELIST')" />
			</h3>
			<div class="alldata">
				<table class="table">
					<tr>
						<th><input id="selectall" name="selectall"
							onClick="checkAll()" type="checkbox" /></th>
						<th><s:property value="getText('user.USERID')" /></th>
						<th><s:property value="getText('user.NAME')" /></th>
						<th><s:property value="getText('user.CATEGORY')" /></th>
						<th><s:property value="getText('user.SEX')" /></th>
						<th><s:property value="getText('user.ADDRESS')" /></th>
						<th><s:property value="getText('user.E-MAIL')" /></th>
					</tr>
					<s:if test="list.empty">
						<tr>
							<td colspan="7" align="center"><s:property
									value="getText('user.NORECORD(S)FOUND')" /></td>
						</tr>
					</s:if>
					<s:else>
						<s:iterator value="list">
							<tr>
								<td><input onclick="operation()" class="checkbox"
									name="check[]" type="checkbox"
									value="<s:property value="userid"/>" /></td>
								<td><s:property value="userid" /></td>
								<td><s:property value="FirstName" /></td>
								<td><s:property value="category" /></td>
								<td><s:property value="Gender" /></td>
								<td><s:property value="address" /></td>
								<td><s:property value="EmailId" /></td>
							</tr>
						</s:iterator>
					</s:else>
				</table>
			</div>
			<div class="btns" style="float: right">
				<span class="upspan" onClick="disable()"> <a href="#"
					id="update" class="btn btn-success"> <s:property
							value="getText('user.UPDATE')" />
				</a>
				</span> <span class="despan" onClick="disable()"> <a href="#"
					id="detail" class="btn btn-success" onClick="disable()"> <s:property
							value="getText('user.DETAILS')" />
				</a>
				</span>
				<form onsubmit="return userArray()" action="deleteaction.action"
					style="display: inline">
					<input type="hidden" name="userids" id="uids" /> <input
						type="submit" id="delete" class="btn btn-success"
						value="<s:property value = "getText('user.DELETE')" />" />
				</form>
				<a href="/WelcomeProject/jsp/Register.jsp" id="register"
					class="btn btn-success"><s:property
						value="getText('user.REGISTER')" /></a> <br /> <br /> <br />
			</div>
		</div>

	</div>

</body>
</html>
