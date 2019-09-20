<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styleUserInfo.css">
<title>Edit User</title>
</head>
<body style="background-color: #F5DEB3">
	<div class="container">
		<div class="Editdet">
			<div class="perdet">
				<h1 style='font-family: MV Boli; margin-left: 500px;'>Update
					Details</h1>
			</div>

			<s:form action="updateaction" method="post">
				<table class="table1">
						<tr>
						<td><label>Salutation : </label></td>
						<td><select name="listbean.salutation">
								<option value="Mr" <s:if test= 'listbean.salutation == "Mr."'>selected</s:if> >Mr.</option>
								<option value="Miss"  <s:if test= 'listbean.salutation == "Ms."'>selected</s:if>>Ms.</option>
								<option value="Mrs"  <s:if test= 'listbean.salutation == "Dr."'>selected</s:if>>Dr.</option>
						</select></td>
					</tr>

					<tr>
						<td><label for="fname">FirstName : </label><span>*</span></td>
						<td><input type="text" name="listbean.FirstName" id="fname"
							maxlength="50" required
							value="<s:property value="listbean.FirstName"/>" /></td>
					</tr>
					<tr>
						<td><label for="middle">Middle Initial : </label></td>
						<td><input type="text" name="listbean.MiddleName" id="middle"
							maxlength="1" value="<s:property value="listbean.MiddleName"/>" /></td>
					</tr>
					<tr>
						<td><label for="lname">LastName : </label><span>*</span></td>
						<td><input type="text" name="listbean.LastName" id="lname"
							maxlength="50" required
							value="<s:property value="listbean.LastName"/>" /></td>
					</tr>
					<tr>
						<td><label for="sex">Sex : </label><span>*</span></td>
						<td><input type="radio" name="listbean.Gender" id="sex"
							required value="male"
							<s:if test='listbean.Gender == "Male"'>checked</s:if> />male <input
							type="radio" name="listbean.Gender" id="sex" required
							value="female"
							<s:if test='listbean.Gender == "Female"'>checked</s:if> />female</td>
					</tr>
					<tr>
						<td><label for="email">Email Id : </label></td>
						<td><input type="email" name="listbean.emailId" id="email"
							maxlength="50" value="<s:property value="listbean.emailId"/>" /></td>
					</tr>
					<tr>
						<td><label for="birth">Birth Date : </label><span>*</span></td>
						<td><input type="date" name="listbean.birth" id="birth"
							required value="<s:property value="listbean.birth"/>" /></td>
					</tr>
					<tr>
						<td><label for="add">Address : </label></td>
						<td><textarea maxlength="100" cols=21 rows=3
								name="listbean.Address"><s:property
									value="listbean.Address" /></textarea></td>
					</tr>
					<tr>
						<td><label for="userid">UserName : </label><span>*</span></td>
						<td><input type="text" name="listbean.userid" id="userid"
							maxlength="50" required
							value="<s:property value="listbean.userid"/>" /></td>
					</tr>
					<tr>
						<td><label for="password">Password : </label><span>*</span></td>
						<td><input type="password" name="listbean.password" id="password"
							maxlength="50" required value="<s:property value="listbean.password"/>" /></td>
					</tr>
					<tr>
						<td><label>Category : </label></td>
						<td><select name="listbean.category">
								<option value="user"  <s:if test= 'listbean.category == "user"'>selected</s:if> >User</option>
								<option value="admin"   <s:if test= 'listbean.category == "admin"'>selected</s:if> >Admin</option>
						</select></td>
					</tr>

					<tr>
						<td><h3>
								Areas of Interest<span>*</span>
							</h3></td>
					</tr>

					<tr>
						<td>
							<%
								boolean bool_b1 = true, bool_b2 = true, bool_b3 = true, bool_b4 = true;
							%>
							<s:set var="bool_b1"><%=bool_b1%></s:set> <s:set var="bool_b2"><%=bool_b2%></s:set>
							<s:set var="bool_b3"><%=bool_b3%></s:set> <s:set var="bool_b4"><%=bool_b4%></s:set>
							<s:iterator value="listbean.arrList" status="itstatus"
								var="status">

								<s:if test="#status == 'Web Programming' && #bool_b1 == 'true'">
									<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Web Programming"
										<s:if test= "#status == 'Web Programming'">checked</s:if>> Web Programming <br>
									<s:set var="bool_b1" value="false" />
								</s:if>
								<s:if test="#status == 'Database Programming' && #bool_b2 == 'true'">
									<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Database Programming"
										<s:if test= "#status == 'Database Programming'">checked</s:if>> Database Programming <br>
									<s:set var="bool_b2" value="false" />
								</s:if>
								<s:if test="#status == 'Swing Programming' && #bool_b3 == 'true'">
									<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Swing Programming"
										<s:if test= "#status == 'Swing Programming'">checked</s:if>> Swing Programming <br>
									<s:set var="bool_b3" value="false" />
								</s:if>
								<s:if test="#status == 'Mobile Programming' && #bool_b4 == 'true'">
									<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Mobile Programming"
										<s:if test= "#status == 'Mobile Programming'">checked</s:if>> Mobile Programming <br>
									<s:set var="bool_b4" value="false" />
								</s:if>
							</s:iterator> <!-- Remaning checkbox prints here --> <s:if
								test="#bool_b1 == 'true'">
								<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Web Programming"> Web Programming <br>
							</s:if> <s:if test="#bool_b2 == 'true'">
								<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Database Programming"> Database Programming <br>
							</s:if> <s:if test="#bool_b3 == 'true'">
								<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Swing Programming"> Swing Programming <br>
							</s:if> <s:if test="#bool_b4 == 'true'">
								<input type="checkbox" name="listbean.areaofinterest" id="interest" value="Mobile Programming"> Mobile Programming <br>
							</s:if>
						</td>
					</tr>

				    <tr>
						<td><h3>
								Other Interest
							</h3></td>
					</tr>
					<tr>
						<td><textarea cols=21 rows=3 name="listbean.otherinterest"
								id="otherinterest"><s:property
									value="listbean.otherinterest" /></textarea></td>
					</tr>
					<tr>
						<td><input type='submit' class="btn btn-success"
							name="update" value="update" /></td>
					</tr>
				</table>

			</s:form>
			<div
				style="padding-bottom: 50px; padding-top: 50px; padding-left: 580px; float: right;">
				<a href="http://localhost:8080/WelcomeProject/">Logout</a>
			</div>
			<div>
				<p id="demo"></p>
			</div>
		</div>
	</div>

</body>
</html>