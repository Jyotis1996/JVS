<!DOCTYPE >
<html>
<head>
<title>Upload files</title>
</head>
<body>

    <div style="padding:5px; color:red;font-style:italic;">
       ${errorMessage}
    </div>

    <h2>Upload Files</h2>

    <form method="post" action="${pageContext.request.contextPath}/uploadToDB"
        enctype="multipart/form-data">

        Select file to upload:
        <input type="file" name="file"  required placeholder="Please select the file to upload" />
        <br />
        Description:
        <br />
        <input type="text" name="description" size="100" />
        <br />
        <br />
        <input type="submit" value="Upload" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type ="reset" value ="Cancel"/>
    </form>

</body>
</html>