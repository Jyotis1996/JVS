<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=Shift_JIS"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<title>Download File</title>
<script type="text/javascript">
function validate()
	{
	var filename = document.getElementsByName('download');
    var genValue = false;

    for(var i=0; i<filename.length;i++){
        if(filename[i].checked == true){
            genValue = true;
        }
    }
    if(!genValue){
    	document.getElementById('errors1').innerHTML="*Please Select File*";
        return false;
    }
	}
</script>
<style type="text/css">
.required {  /* Marker for required fields */
   color: red;
}

th {
	text-align: left;
	font-size: 20px;
	color: darkblue;
	background-color: grey;
 }

table {
	border-color: green;
	background-color: lightgrey;
}
</style>
</head>
<body>
<h2><center>List of Files</center></h2>
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_jyoti", "jyoti", "jyoti@741");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select * from attachment1");
%>
<form action="${pageContext.request.contextPath}/FileDownload"  method = "get" accept-charset="Shift_JIS">
<table border="1" align="center">
<tr>
<th>ID</th>
<th>File Name</th>
</tr>
<%! int i=0; %>
<%while(rs.next()){%>
<tr>
<td><%= ++i %></td>
<td><input type="radio" name="download" id="radio" value="<%=rs.getString("id") %>"><%= rs.getString("file_name")%></td>
</tr><%} %>
<center><p id="errors1" class="required"></p></center>
<tr>
<td colspan="3"><center><input type="submit" value="Download" onclick="return validate()"></a></center></td></tr>
</table>

</form>

</body>
</html>