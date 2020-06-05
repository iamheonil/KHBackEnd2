<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>파일 업로드 Form</h1>
	<h3>cos Fileupload</h3>
	<br>
	<hr>

	<form action="/file/upload" method="post" enctype="multipart/form-data">

		<label>제목 : <input type="text" name="title"></label><br>
		<label>닉네임 : <input type="text" name="nick"></label><br>
		<br> 
		<label>파일 : <input type="file" name="upfile"></label><br>
		<br>

		<button>전송</button>

	</form>

</body>
</html>