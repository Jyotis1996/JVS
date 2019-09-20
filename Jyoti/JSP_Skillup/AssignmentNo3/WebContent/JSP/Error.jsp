<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/UserDetails.css" />

</head>

<body>

	<div class="exactCenter">

		<table align="center" cellpadding="2"
			style="text-align: center; color: red; background: none;">

			<tr>
				<td><b>Error Occurred : </b> <c:choose>
						<c:when test="${empty Error}">
				      		NullPointerException
				      	</c:when>

						<c:otherwise>
				      		${Error}
				      	</c:otherwise>
					</c:choose></td>
			</tr>

		</table>

	</div>

</body>
</html>