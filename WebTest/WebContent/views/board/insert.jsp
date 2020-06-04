<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>insert Page</h1>
	<h3>Welcome</h3>
	<hr>

	<form action="<%=request.getContextPath()%>/board/insert" method="Post">

		<label>아이디 <input type="text" name="uid"></label><br>
		<label>패스워드 <input type="password" name="upw"></label><br><br>

		<button>가입</button>

	</form>

</body>
</html>