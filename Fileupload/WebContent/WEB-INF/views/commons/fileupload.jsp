<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> 파일업로드 </h1>
<hr>
	<form action="/commons/fileupload" method="post" enctype="multipart/form-data">
	
		<label>제목 : <input type="text" name="title" id="title"> </label><br>
		<label>데이터1 : <input type="text" name="data1" id="data1"> </label><br>
		<label>데이터2 : <input type="text" name="data2" id="data2"> </label><br>

		<label>파일 : <input type="file" name="upfile" id="upfile"> </label><br>
	
		<button>전송</button>
	</form>

</body>
</html>