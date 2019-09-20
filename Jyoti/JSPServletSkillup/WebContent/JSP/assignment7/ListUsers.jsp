<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ListUsers</title>

<META NAME="Description" CONTENT="ListUsers">

<Link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/Login.css" />

</head>

<body>

	<div style="overflow: scroll; width: 1325px; height: 630px;">

		<TABLE align="center" style="background: none; color: red;"
				width="240px">
				<TR>
					<TD align="left">&nbsp;${Message}</TD>
				</TR>
			</TABLE>

		<TABLE align="center" border="2" cellpadding="2">
			<TH colspan="6">List of Registered Users</TH>

			<TR>
				<TD align="center"><B>Sr. No.</B></TD>
				<TD align="center"><B>Name</B></TD>
				<TD align="center"><B>Email Id</B></TD>
				<TD align="center"><B>Birth Date</B></TD>
				<TD align="center"><B>Address</B></TD>
				<TD align="center"><B>Area of Interests</B></TD>
					<c:set var="counter" value="1"/>
					<c:forEach var="iUser" items="${UserList}">

						<!-- <c:set var="values" value="${fn:split(iUser, ' ')}" /> -->

						<c:set var="values" value="${iUser}" />

						<form name="form${counter}"
							action="${pageContext.request.contextPath}/Login" method="post">

							<input type="hidden" name="EditUpdate" value="Edit">

							<TR>
								<TD align="center">${counter}</TD>
								<TD>${values.salutation} ${values.firstName} ${values.middleInitial} ${values.lastName}</TD>
								<TD>${values.emailId}</TD>
								<TD>${values.birthDate}</TD>
								<TD>${values.address}</TD>
								<TD>
									<c:forEach var="iInterest" items="${values.areaOfInterest}">
										${iInterest},
									</c:forEach>
									${values.otherInterests}
								</TD>
								<TD><input type="hidden" name="userId" value="${values.userId}">
									<input type="hidden" name="password" value="${values.password}">
									<input type="submit" value="Edit"></TD>
							</TR>
						</form>
						<c:set var="counter" value="${counter+1}"/>
					</c:forEach>
			</TR>
		</TABLE>
	</div>

</body>

</html>