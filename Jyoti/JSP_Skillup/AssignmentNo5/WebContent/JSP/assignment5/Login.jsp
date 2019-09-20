<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

<META NAME="Description" CONTENT="Login">

<Link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/CSS/Login.css" />

</head>

<body>

	<!-- To submit the input data -->
	<FORM METHOD=POST ACTION="${pageContext.request.contextPath}/Login">

		<div class="center">
			<TABLE align="center" style="background: none; color: red;"
				width="240px">
				<TR>
					<TD align="left">&nbsp;${Message}</TD>
				</TR>
			</TABLE>

			<!-- Table with border and center of page body -->
			<TABLE border="2" align="center" cellspacing="3">

				<TH>Login Details</TH>
				<TR>
					<TD>
						<TABLE>

							<TR>
								<TD><Label for="LoginID"> Login ID <Font>*</Font></Label></TD>
								<TD><Input Type="text" name="userId" Id="LoginID"
									maxlength="50" value='${userBean.userId}'></TD>
								<!-- Text field -->
							</TR>
							<TR>
								<TD><Label for="Password"> Password <Font>*</Font></Label>
								</TD>
								<TD><Input Type="password" name="password" Id="Password"
									maxlength="50"></TD>
								<!-- Password field -->
							</TR>
						</TABLE>
						<TABLE align="center">
							<TR>
								<TD><Input type="submit" value="Submit"></TD>
								<!-- To send form data -->
								<TD><Input type="reset" value="Reset"  onclick ="clearFormData();"></TD>
							</TR>
						</TABLE>
					</TD>
				</TR>
			</TABLE>

		</div>

	</FORM>

	<script type="text/javascript">
		document.getElementById("LoginID").focus();

		function clearFormData() {
			document.forms[0].action = '${pageContext.request.contextPath}/Login_pre';
			document.forms[0].submit;
		}
	</script>

</body>

</html>