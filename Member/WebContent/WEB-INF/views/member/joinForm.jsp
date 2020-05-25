<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/member/join" method="post">
		아이디 : <input type="text" id="uid" name="uid"> <br>
		닉네임 : <input type="text" id="unick" name="unick"> <br>
		이메일 : <input type="email" id="uemail" name="uemail"> <br>
		<br>
		<input type="submit" value="전송하기">
	</form>
</body>
</html>