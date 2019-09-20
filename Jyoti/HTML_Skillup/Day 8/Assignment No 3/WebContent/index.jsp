<%-- file name:index.jsp
     description:file upload gui
     @author:Jyoti --%>
<!DOCTYPE html>
<html>
<head>
<title>File Upload with Progress Bar</title>
<!-- Include jQuery form & jQuery script file. -->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8/jquery.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="js/fileUploadScript.js"></script>
<!-- Include css styles here -->
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<h3 align="center">File Upload with Progress Bar</h3>
	<form id="UploadForm" action="UploadFile" method="post"
		enctype="multipart/form-data">
		<input type="file" size="60" id="myfile" name="myfile"><br>
		<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit"
			value="File Upload">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="button" name="clear" value="Clear" onclick="this.form.reset()">
		<br> <br>
		<div id="progressbox">
			<div id="progressbar"></div>
			<div id="percent">0%</div>
		</div>
		<br />

		<div id="message"></div>
	</form>
</body>
</html>
