<html>
<body>
	<form method="GET" enctype="multipart/form-data"  
		action="<c:url value="/file/upload" />">
		File to upload: <input type="file" name="file"><br /> Name: <input
			type="text" name="name"><br /> <br /> <input type="submit"
			value="Upload"> Press here to upload the file!
	</form>
</body>
</html>