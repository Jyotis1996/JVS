<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="styleUserInfo.css">
<title>Register</title>
<script src="Register.js"></script>
</head>
<body style="background-color: #F5DEB3">
	<div class="main container">
		<div class="perdet">
			<h1 style='font-family: MV Boli; margin-left: 500px;'>Register</h1>
		</div>
		<s:form action="registeraction" method="post"
			onsubmit="return success()">
			<table
				style="border-width: 2px; border-style: solid; margin-left: 380px; margin-top: 30px; font-family: MV Boli; border-spacing: 10px; align: center;">
				<tr>
					<td><label>Salutation : </label></td>
					<td><select name="formList.salutation">
							<option value="Mr.">Mr.</option>
							<option value="Ms.">Ms.</option>
							<option value="Dr.">Dr.</option>
					</select></td>
				</tr>

				<tr>
					<td><label for="fname">FirstName : </label><span>*</span></td>
					<td><input type="text" name="formList.firstName"
						id="firstName" maxlength="50" required /></td>
				</tr>
				<tr>
					<td><label for="middle">Middle Initial : </label></td>
					<td><input type="text" name="formList.middleName"
						id="middleName" /></td>
				</tr>
				<tr>
					<td><label for="lname">LastName : </label><span>*</span></td>
					<td><input type="text" name="formList.lastName" id="lastName"
						maxlength="50" required /></td>
				</tr>
				<tr>
					<td><label for="sex">Sex : </label><span>*</span></td>
					<td><input type="radio" name="formList.Gender" id="gender"
						value="male" />male <input type="radio" name="formList.gender"
						id="gender" required value="female" checked />female</td>
				</tr>
				<tr>
					<td><label for="email">Email Id : </label></td>
					<td><input type="email" name="formList.emailId" id="emailId"
						maxlength="50" /></td>
				</tr>
				<tr>
					<td><label for="dob">Birth Date : </label><span>*</span></td>
					<td><input type="date" name="formList.dob" id="dob" required /></td>
				</tr>
				<tr>
					<td><label for="add">Address : </label></td>
					<td><textarea maxlength="100" cols=21 rows=3
							name="formList.address" id="address"></textarea></td>
				</tr>
				<tr>
					<td><label for="userid">UserName : </label><span>*</span></td>
					<td><input type="text" name="formList.userid" id="userid"
						maxlength="50" required /></td>
				</tr>
				<tr>
					<td><label for="password">Password : </label><span>*</span></td>
					<td><input type="password" name="formList.password"
						id="password" maxlength="50" required
						placeholder="Enter your password" /></td>
				</tr>
				<tr>
					<td><label>Category : </label><span>*</span></td>
					<td><select name="formList.category">
							<option value="user">User</option>
							<option value="admin">Admin</option>
					</select></td>
				</tr>
				<tr>
					<td><h3>
							Areas of Interest<span>*</span>
						</h3></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="formList.areaofinterest"
						id="interest" value="web"> Web Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="formList.areaofinterest"
						id="interest" value="database"> Database Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="formList.areaofinterest"
						id="interest" value="swing"> Swing Programming <br></td>
				</tr>
				<tr>
					<td><input type="checkbox" name="formList.areaofinterest"
						id="interest" value="mobile">Mobile Programming <br></td>
				</tr>
				<tr>
					<td><h3>Other Interest:</h3></td>
				</tr>
				<tr>
					<td><textarea cols=21 rows=3 name="formList.otherinterest"
							id="othintrest"></textarea></td>
				</tr>
				<tr>
					<td><input type='submit' class="btn btn-success" name="submit"
						value="Register" /> <input type='reset' class="btn btn-success"
						name="clear" value="Clear" /></td>
				</tr>
			</table>
		</s:form>
		<div
			style="padding-bottom: 50px; padding-top: 50px; padding-left: 580px; float: right;">
			<a href="http://localhost:8080/WelcomeProject/">Logout</a>
		</div>
	</div>
</body>
</html>