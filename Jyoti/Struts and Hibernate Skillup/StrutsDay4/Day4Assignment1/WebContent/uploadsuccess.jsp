<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>UpLoadSuccess</title>
</head>
<style>
.content {
	max-width: 1000px;
	margin: auto;
}
</style>
<body>
	<div class="content">
	<h2>Struts2 File Upload Example</h2>
	User File: <s:property value="fileUpload"/>
	<br/>
	Content Type: <s:property value="fileUploadContentType"/>
	<br/>
	File Name: <s:property value="fileUploadFileName"/>
	<br/>
	Uploaded Image:
	<br/>
	<img src="D:/Struts/Day4Assignment1/WebContent/WEB-INF/Upload/<s:property value="fileUploadFileName"/>" width="400" height="400" alt="Image Preview"/>
	</div>
</body>
</html>