<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>Csv File Download</title>
</head>
<body>
<h2><center>Csv File Download</center></h2>
<form action="${pageContext.request.contextPath}/CSVDownload" accept-charset="Shift_JIS">
<table border="1" align="center">
<tr>
<td colspan="3"><center><input type="submit" value="Download"></center></td>
</tr>
</table>
</form>
</body>
</html>