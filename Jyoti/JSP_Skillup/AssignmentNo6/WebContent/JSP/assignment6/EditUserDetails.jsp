<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EditUserDetails</title>

<META NAME="Description" CONTENT="EditUserDetails">

<Link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/UserDetails.css" />

</head>

<body>

	<div align="center" style="color: green; font-weight: bold;">${Message}</div>

	<!-- HTML Form to submit data -->
	<FORM METHOD="POST"
		action="${pageContext.request.contextPath}/EditUserDetails"  >

		<c:forEach var="iInterest" items="${userBean.areaOfInterest}">

			<c:if test="${fn:trim(iInterest) eq 'Web Programming'}">
				<c:set var="webProgramming" value="true">
				</c:set>
			</c:if>
			<c:if test="${fn:trim(iInterest) eq 'Database Programming'}">
				<c:set var="databaseProgramming" value="true">
				</c:set>
			</c:if>
			<c:if test="${fn:trim(iInterest) eq 'Swing Programming'}">
				<c:set var="swingProgramming" value="true">
				</c:set>
			</c:if>
			<c:if test="${fn:trim(iInterest) eq 'Mobile Programming'}">
				<c:set var="mobileProgramming" value="true">
				</c:set>
			</c:if>
		</c:forEach>

		<TABLE align="center" style="background: none; color: red;"
			width="320px">
			<TR>
				<TD align="left">${validation.errorMessage}</TD>
			</TR>
		</TABLE>

		<TABLE align="center" border="2" cellpadding="2">

			<TH colspan="4">Personal Details</TH>

			<TR>
				<TD><label for="UserID"> UserId <Font>*</Font> </label>
				</TD>
				<TD colspan="3"><input type="text" id="UserID" name="userId"
					value='${userBean.userId}' readonly>
				</TD>
			</TR>
			<TR>
				<TD><label for="Password"> Password <Font>*</Font> </label>
				</TD>
				<TD colspan="3"><input type="password" id="Password"
					name="password" value='${userBean.password}' maxlength="50" ${ReadOnly}>
				</TD>
			</TR>
			<TR>
				<TD><label for="salutation">Salutation</label>
				</TD>
				<TD colspan="3"><SELECT name="salutation" id="salutation" ${Disabled}>
						<OPTION></OPTION>
						<OPTION
							<c:if test="${userBean.salutation == 'Mr.'}">selected</c:if>>
							Mr.</OPTION>
						<OPTION
							<c:if test="${userBean.salutation == 'Ms.'}">selected</c:if>>
							Ms.</OPTION>
						<OPTION
							<c:if test="${userBean.salutation == 'Mrs.'}">selected</c:if>>
							Mrs.</OPTION>
						<OPTION
							<c:if test="${userBean.salutation == 'Dr.'}">selected</c:if>>
							Dr.</OPTION>
				</SELECT></TD>
			</TR>
			<TR>
				<TD><label for="firstName">First Name <Font>*</Font>
				</label>
				<TD colspan="3"><Input type="text" name="firstName"
					id="firstName" value='${userBean.firstName}' maxlength="50">
			<TR>
				<TD><label for="middleInitial">Middle Initial</label>
				<TD colspan="3"><Input type="text" name="middleInitial"
					id="middleInitial" value='${userBean.middleInitial}' maxlength="50">
			<TR>
				<TD><label for="lastName">Last Name <Font>*</Font>
				</label>
				<TD colspan="3"><Input type="text" name="lastName"
					id="lastName" value='${userBean.lastName}' maxlength="50">
			<TR>
				<TD>Sex <Font>*</Font>
				<TD><Input type="radio" name="sex" class="radios" value="Male"
					<c:if test="${userBean.sex == 'Male'}">checked</c:if>>Male



				<TD><Input type="radio" name="sex" class="radios"
					value="Female"
					<c:if test="${userBean.sex == 'Female'}">checked</c:if>>Female




			<TR>
				<TD><label for="emailId">Email Id</label>
				<TD colspan="3"><Input type="text" name="emailId" id="emailId"
					value='${userBean.emailId}' maxlength="50">
			<TR>
				<TD>Birth Date <Font>*</Font>
				<TD colspan="2"><SELECT name="day" ${Disabled} >
						<OPTION value= ${day } <c:if test="${userBean.birthDay == Day}">selected</c:if>>Day</OPTION>
						<c:forEach var="intDay" begin="1" end="31">
							<OPTION value=${intDay
								}
								<c:if test="${userBean.birthDay == intDay}">selected</c:if>>${intDay}</OPTION>
						</c:forEach>
				</SELECT> <SELECT name="month" ${Disabled}>
						<OPTION value= ${month } <c:if test="${userBean.birthDay == Month}">selected</c:if>>Month</OPTION>

						<c:forEach var="intMonth" begin = "1" end="12">
							<OPTION value=${intMonth
								}
								<c:if test="${userBean.birthMonth == intMonth}">selected</c:if>>${intMonth}</OPTION>
						</c:forEach>
				</SELECT> <SELECT name="year" ${Disabled}>
						<OPTION value= ${year } <c:if test="${userBean.birthDay == Year}">selected</c:if>>Year</OPTION>

						<c:forEach var="intYear" begin="1990" end="2019">
							<OPTION value=${intYear
								}
								<c:if test="${userBean.birthYear == intYear}">selected</c:if>>${intYear}</OPTION>
						</c:forEach>

				</SELECT>
			<TR>
				<TD><label for="address">Address</label>
				<TD colspan="2"><textarea name="address" id="address"
						onkeypress="return imposeMaxLength(event, this, 100);">${userBean.address}</textarea>
			<TR>

				<TH colspan="4">Areas of Interest <Font>*</Font></TH>
			<TR>

				<TD colspan="4"><Input class="checkboxes" name="interest"
					type="checkbox" value="Web Programming"
					<c:if test="${webProgramming}">checked</c:if>>Web
					Programming
			<TR>
				<TD colspan="4"><Input class="checkboxes" name="interest"
					type="checkbox" value="Database Programming"
					<c:if test="${databaseProgramming}">checked</c:if>>Database
					Programming
			<TR>
				<TD colspan="4"><Input class="checkboxes" name="interest"
					type="checkbox" value="Swing Programming"
					<c:if test="${swingProgramming}">checked</c:if>>Swing
					Programming
			<TR>
				<TD colspan="4"><Input class="checkboxes" name="interest"
					type="checkbox" value="Mobile Programming"
					<c:if test="${mobileProgramming}">checked</c:if>>Mobile
					Programming
			<TR>
				<TD colspan="4"><label for="otherInterests"><b>Other
							Interests</b> </label>

			<TR>
				<TD colspan="4"><textarea name="otherInterests"
						id="otherInterests" rows="4" style="overflow-y: scroll">${userBean.otherInterests}</textarea>
			<TR>
				<TD colspan="3" align="center">
					<Input class="buttons" name="EditUpdate" type="submit" value="${EditUpdate}"
					id="Edit_Update" onclick="editUpdate();">
					<!-- onclick="return setReadOnly(false);">  <Input class="buttons" type="button" value="Reset" id="Reset" onclick="clearFormData();" disabled="disabled"> -->
					<Input class="buttons" type="submit" value="${LogOutCancel}"
					id="Cancel_Logout" onclick="cancelEdit();">
				</TD>
			</TR>
		</TABLE>

	</FORM>

	<script type="text/javascript">
			function editUpdate()
			{
				var Edit_Update = document.getElementById("Edit_Update").value;

				if(Edit_Update == "Edit")
				{
					var elementLength = document.forms[0].elements.length;

				    for(i=1; i<elementLength; i++)
				    {
				    	var elementType = document.forms[0].elements[i].type;

				    	if(elementType == "radio" || elementType == "select-one" || elementType == "checkbox")
				    	{
				    		document.forms[0].elements[i].disabled = false;
				    	}
				    }

					document.forms[0].action = '${pageContext.request.contextPath}/Login';
				}
				else if(Edit_Update == "Update")
				{
					valid = true;

					if(document.forms[0].day.value == "Day" || document.forms[0].month.value == "Month" || document.forms[0].year.value == "Year" )
						{
						   out.println("<TABLE align=center background-color = white width=320px>");
						   out.println("<TD><font color=red>Please Select day,month and year</font></TD>");
						   out.println("</TABLE>");
						   valid = false;
						}
					return valid;
					document.forms[0].action = '${pageContext.request.contextPath}/EditUserDetails';
				}
				document.forms[0].submit;
			}
			function cancelEdit()
			{
				var Cancel_Logout = document.getElementById("Cancel_Logout").value;

				if(Cancel_Logout == "Logout")
				{
					document.forms[0].action = '${pageContext.request.contextPath}/Login_pre';
				}
				else if(Cancel_Logout == "Cancel")
				{
					document.forms[0].action = '${pageContext.request.contextPath}/Login';
				}
				document.forms[0].submit;
			}

			function imposeMaxLength(Event, Object, MaxLen)
			{
			    return (Object.value.length <= MaxLen)||(Event.keyCode == 8 ||Event.keyCode==46||(Event.keyCode>=35&&Event.keyCode<=40))
			}
		</script>

</body>

</html>