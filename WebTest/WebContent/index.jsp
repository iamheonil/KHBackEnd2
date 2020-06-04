<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Main Page</h1>
	<h3>Welcome !</h3>
	<hr>

	<%-- 컨텍스트 패스 : Request 정보 객체에 들어있음 --%>
	<a href="<%=request.getContextPath() %>/board/insert"><button>입력페이지</button></a>

</body>
</html>